package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.R;

import org.w3c.dom.Text;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView registerEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        registerEdit = (TextView) findViewById(R.id.registerTextView);

        registerEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == registerEdit) {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
