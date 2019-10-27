package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppActivity extends AppCompatActivity {

    @BindView(R.id.makeChoice) Button mMakeChoice;
    @BindView(R.id.text1) EditText mText1;
    @BindView(R.id.text2) EditText mText2;
    @BindView(R.id.text3) EditText mText3;
    @BindView(R.id.text4) EditText mText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        ButterKnife.bind(this);

        mMakeChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mText1.getText().toString();
                String email = mText2.getText().toString();
                String location = mText3.getText().toString();
                String type = mText4.getText().toString();

                Intent choice = new Intent(AppActivity.this, FinalActivity.class);
//                choice.putExtra("name", name);
//                choice.putExtra("email", email);
                choice.putExtra("location", location);
//                choice.putExtra("type", type);
                startActivity(choice);
//                Toast.makeText(AppActivity.this, "Your order have been received successfully ...We were inform you .. ", Toast.LENGTH_SHORT).show();

//
            }
        });

    }
}