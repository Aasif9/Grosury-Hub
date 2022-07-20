package com.example.grosury.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.grosury.MainActivity;
import com.example.grosury.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button signIn;
    TextView signUp;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    FirebaseDatabase database;
    //For signing in with google
    //GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.signEmail);
        password=findViewById(R.id.signPassword);
        signIn=findViewById(R.id.signIn);
        signUp=findViewById(R.id.signup);

   // getSupportActionBar().hide();

    mAuth = FirebaseAuth.getInstance();
    database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Please Wait,\nValidation in Progress");


        signIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {

                progressDialog.show();

                mAuth.signInWithEmailAndPassword
                        (email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            else {
                Toast.makeText(LoginActivity.this, "Enter Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    });

    //here we see if the user is already log in then move to Main Activity
    //without having to log in again
        if (mAuth.getCurrentUser() != null) {
        Intent intent = new Intent(LoginActivity.this, HomeActivityDetails.class);
        startActivity(intent);
    }

        signUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);

        }
    });


}

}
