package com.example.androidproject.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.InvocationTargetException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = SignUpActivity.class.getSimpleName();

 private EditText mNameEdit;
 private EditText mEmailEdit;
 private EditText mPasswordText;

 private EditText mComfirmPassword;
 private Button mSignUp;
 private TextView mLogIn;

 private FirebaseAuth mAuth;
 private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mNameEdit = (EditText) findViewById(R.id.nameText);
        mEmailEdit = (EditText) findViewById(R.id.emailText);
        mPasswordText =(EditText) findViewById(R.id.passwordText);
        mComfirmPassword =(EditText) findViewById(R.id.confirmPassword);
        mSignUp =(Button) findViewById(R.id.createUser);
        mLogIn=(TextView) findViewById(R.id.login);


        mLogIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        signUpAuthStateListener();
    }

    @Override
    public void onClick(View v) {
        if (v == mLogIn) {
            Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v == mSignUp) {
            signUp();
        }
    }

    private void signUp() {

        final String name = mNameEdit.getText().toString().trim();
        final String email = mEmailEdit.getText().toString().trim();
        final String password = mPasswordText.getText().toString().trim();
        final String comfirmPassword = mComfirmPassword.getText().toString().trim();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signUpAuthStateListener() {

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}