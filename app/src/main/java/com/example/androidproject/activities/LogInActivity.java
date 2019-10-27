package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidproject.R;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView registerEdit;

    private EditText mPasswordEdit;
    private EditText mEmailEdit;
    private Button mPassword ;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        registerEdit = (TextView) findViewById(R.id.registerTextView);
        mEmailEdit = (EditText) findViewById(R.id.email);
        mPassword =(Button) findViewById (R.id.loginButton);
        mPasswordEdit =(EditText) findViewById(R.id.password) ;

        registerEdit.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == registerEdit) {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
        if (v == mPassword) {
            loginWithPassword();
        }

    }

    private void loginWithPassword() {
    }
}
