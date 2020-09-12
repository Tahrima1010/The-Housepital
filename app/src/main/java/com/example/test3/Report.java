package com.example.test3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Report extends AppCompatActivity implements View.OnClickListener {
    private Button camerabutton,sharebutton,gallerybutton,savebutton,displaybutton;
    private EditText nameedittext;
    private ImageView imageView;
    private Uri imageUri;
    private static final int IMAGE_REQUEST=1;
    DatabaseReference databaseReference1;
    StorageReference storageRefrence1;
    StorageTask uploadTask;
    String file_path=null;
    private static final int PERMISSION_REQUEST_CODE=101;
    private static final int CAMERA_REQUEST=102;
    String[] all_permission={Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        databaseReference1 = FirebaseDatabase.getInstance().getReference("Upload");
        storageRefrence1 = FirebaseStorage.getInstance().getReference("Upload");

        camerabutton=(Button) findViewById(R.id.reportbutton1);
        gallerybutton=(Button)findViewById(R.id.reportbutton2);
        savebutton=(Button)findViewById(R.id.reportbutton3);
        displaybutton=(Button)findViewById(R.id.reportbutton4);
        imageView=(ImageView)findViewById(R.id.image1);
        nameedittext=(EditText)findViewById(R.id.reportedittext1);
        sharebutton=(Button) findViewById(R.id.reportbuttonshare);

        camerabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=23){
                    if(checkPermission(all_permission)){
                        camerabutton();
                    }
                    else{
                        requestPermission(all_permission);
                    }
                }
                else{
                    camerabutton();
                }

            }
        });




        gallerybutton.setOnClickListener(this);
        savebutton.setOnClickListener(this);
        displaybutton.setOnClickListener(this);


        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //now for sharing file i need to create file provider for android version greater than noughat let's do it
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Demo Title");
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
                    Uri path= FileProvider.getUriForFile(Report.this,"com.example.test3",new File(file_path));
                    intent.putExtra(Intent.EXTRA_STREAM,path);
                }
                else{
                    intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(file_path)));
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setType("plain/*");
                startActivity(intent);


                //Everything WOrking


            }
        });

    }
    private void camerabutton(){

        //Permisson Working Now
        //Save our Capture Image Now and Later i can share image
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);

    }
    private boolean checkPermission(String[] permisson){
        for(int i=0;i<permisson.length;i++){
            int result= ContextCompat.checkSelfPermission(Report.this,permisson[i]);
            if(result== PackageManager.PERMISSION_GRANTED){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private void requestPermission(String[] permission){
        ActivityCompat.requestPermissions(Report.this,permission,PERMISSION_REQUEST_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Report.this, "Permission Successfull", Toast.LENGTH_SHORT).show();
                    camerabutton();

                }
                else{
                    Toast.makeText(Report.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
        }
    }




    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.reportbutton2:
                openFileChooser();
                break;
            case R.id.reportbutton3:
                if(uploadTask!=null && uploadTask.isInProgress())
                {
                    Toast.makeText(getApplicationContext(),"Progress",Toast.LENGTH_LONG).show();
                }else{
                    saveData();
                }

                break;
            case R.id.reportbutton4:
                Intent intent=new Intent(Report.this,reportimage.class);
                startActivity(intent);
                break;

        }
    }

    void openFileChooser() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            imageUri=data.getData();
            Picasso.with(this).load(imageUri).into(imageView);
        }
        if(resultCode== Activity.RESULT_OK){
            if(requestCode==CAMERA_REQUEST){
                if(data!=null){
                    Bitmap image= (Bitmap) data.getExtras().get("data");
                    ByteArrayOutputStream bytes=new ByteArrayOutputStream();
                    image.compress(Bitmap.CompressFormat.JPEG,100,bytes);
                    File dest=new File(Environment.getExternalStorageDirectory(),"temp_img.jpg");
                    if(dest.exists()){
                        dest.delete();
                    }

                    FileOutputStream fo;
                    try{
                        fo=new FileOutputStream(dest);
                        fo.write(bytes.toByteArray());
                        fo.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                    imageView.setImageBitmap(image);

                    file_path=dest.getPath();
                    //capture working let's share image
                }
            }
        }


    }
    public  String getFileExtension(Uri imageUri){
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));



    }


    private void saveData()
    {
        final String imageName=nameedittext.getText().toString().trim();
        if(imageName.isEmpty())
        {
            nameedittext.setError("Enter name");
            nameedittext.requestFocus();
            return;
        }


        StorageReference ref=storageRefrence1.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));
        ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                        Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                        while(!urlTask.isSuccessful());
                        Uri downloadUrl =urlTask.getResult();


                        Upload upload=new Upload(imageName,downloadUrl.toString());
                        String uploadID=databaseReference1.push().getKey();
                        databaseReference1.child(uploadID).setValue(upload);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(getApplicationContext(), "UnSuccessful", Toast.LENGTH_LONG).show();
                    }
                });
    }
}