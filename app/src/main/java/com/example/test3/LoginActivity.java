package com.example.test3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText emailtext,passwordtext;
    private Button signbutton;
    private TextView textviewid,forgettextlink;
    ProgressBar ProgressBar;
    CheckBox showpass;
    private FirebaseAuth mAuth;//instance for firebase authentication


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Login  Activity");
        mAuth = FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide actionbar

        ProgressBar=findViewById(R.id.progress1);
        emailtext=(EditText) findViewById(R.id.text2);
        passwordtext=(EditText) findViewById(R.id.text3);
        showpass=findViewById(R.id.showpassword);
        forgettextlink=findViewById(R.id.forgetpass);
        signbutton=(Button) findViewById(R.id.bit1);
        textviewid=(TextView) findViewById(R.id.textviewid2);
        signbutton.setOnClickListener(this);
        textviewid.setOnClickListener(this);
        forgettextlink.setOnClickListener(this);

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    passwordtext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else
                {
                    passwordtext.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bit1 :
                Userlogin();
                break;
            case R.id.textviewid2 :
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.forgetpass :
                final EditText resetmail= new EditText(v.getContext());
                AlertDialog.Builder passwordresetdialog= new AlertDialog.Builder(v.getContext());
                passwordresetdialog.setTitle("Reset password ?");
                passwordresetdialog.setMessage("Enter Your Email to  Received Reset link  ");
                passwordresetdialog.setView(resetmail);
                passwordresetdialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extrac the mail.send rest link
                        String mail =resetmail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Reset link sent to your email",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext()," Error ! Reset Link is Not Sent"+e.getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        });



                    }
                });
                passwordresetdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog

                    }
                });
                //display the error dialog
                passwordresetdialog.create().show();

                break;




        }

    }

    private void Userlogin() {
        String email =emailtext.getText().toString().trim();
        String password =passwordtext.getText().toString().trim();
        //checking the validity of the email
        if(email.isEmpty())
        {
            emailtext.setError("Enter an email address");
            emailtext.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailtext.setError("Enter a valid email address");
            emailtext.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            passwordtext.setError("Enter a password");
            passwordtext.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            passwordtext.setError("minimum length of a  password should be 8");
            passwordtext.requestFocus();
            return;

        }
        ProgressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                ProgressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    //check email verified or not
                    if(mAuth.getCurrentUser().isEmailVerified())
                    {
                        finish();
                        Intent intent =new Intent(getApplicationContext(),HomeActivity.class);
                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);//can't go back to any other Activity from home
                        startActivity(intent);

                    }else
                    {
                        Toast.makeText(getApplicationContext(),"Please verify your email id ",Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login  Unsuccessful",Toast.LENGTH_SHORT).show();


                }

            }
        });


    }
}
