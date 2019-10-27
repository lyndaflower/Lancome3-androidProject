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

    private SharedPreferences sharedpref;
    private SharedPreferences.Editor mtext;

    @BindView(R.id.makeChoice) Button mMakeChoice;
    @BindView(R.id.text2) EditText mText2;
    @BindView(R.id.text3) EditText mText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        ButterKnife.bind(this);

        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        mtext = sharedpref.edit();

        mMakeChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mMakeChoice) {
                    String location = mText3.getText().toString();
                    addToPreference(location);
                    Intent choice = new Intent(AppActivity.this, FinalActivity.class);
                    ;
                    choice.putExtra("location", location);
                    startActivity(choice);


                }
            }

            private void addToPreference(String location) {
                mtext.putString(Holder.PREFERENCES_LOCATION_KEY,location).apply();
            }
        });

    }
}