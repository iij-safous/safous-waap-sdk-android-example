package com.iij.androidExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.safous.waap.ApiProtection;
import java.io.File;

public class ExampleSetupActivity extends AppCompatActivity {

    public static ApiProtection protection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_setup);
        setSetupEnv();
        setNextRegistration();
    }

    public void setSetupEnv(){
        String path = getApplicationContext().getFilesDir().getAbsolutePath();
        File file = new File(path+"/safouswaap.ini");

        protection = new ApiProtection(getApplicationContext());
        protection.setupEnv(getApplicationContext(),file.getAbsolutePath());
    }

    public void setNextRegistration(){
        Intent i = new Intent(getApplicationContext(), ExampleRegisterActivity.class);
        startActivity(i);
    }
}