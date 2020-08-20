package com.example.test3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText signupemailtext,signuppasswordtext;
    private Button signupbutton;
    private TextView signuptextviewid;
    private FirebaseAuth mAuth;
    CheckBox showpass;
    private android.widget.ProgressBar ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide actionbar

        ProgressBar=findViewById(R.id.progress1);
        showpass=findViewById(R.id.showpassword);


        this.setTitle("Regestration Activity");
        signupemailtext=(EditText) findViewById(R.id.signuptext2);
        signuppasswordtext =(EditText) findViewById(R.id.signuptext3);
        signupbutton=(Button) findViewById(R.id.signupbit1);
        signuptextviewid=(TextView) findViewById(R.id.signuptextviewid2);
        signupbutton.setOnClickListener(this);
        signuptextviewid.setOnClickListener(this);
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    signuppasswordtext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else
                {
                    signuppasswordtext.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signupbit1:
                UserRegister();
                break;
            case R.id.signuptextviewid2:
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void UserRegister() {
        String email =signupemailtext.getText().toString().trim();
        String password =signuppasswordtext.getText().toString().trim();
        //checking the validity of the email
        if(email.isEmpty())
        {
            signupemailtext.setError("Enter an email address");
            signupemailtext.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupemailtext.setError("Enter a valid email address");
            signupemailtext.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            signuppasswordtext.setError("Enter a password");
            signuppasswordtext.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            signuppasswordtext.setError("minimum length of a  password should be 8");
            signuppasswordtext.requestFocus();
            return;

        }

        ProgressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                ProgressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    //from firebase to get current user and send verification mcz
                    //addcompletelisitener to know whether email verification link send properly or not
                   mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               // Sign in success, update UI with the signed-in user's information
                               finish();
                               Intent intent =new Intent(getApplicationContext(),HomeActivity.class);
                               Toast.makeText(getApplicationContext()," User Registered Successfully .please verify your email id.",Toast.LENGTH_SHORT).show();

                               intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                               startActivity(intent);
                           }else
                           {
                               Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                           }

                       }
                   });



                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext()," You are  already Registered ",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }



                }

            }
        });





    }
}
