package com.iij.androidExample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.safous.waap.ApiProtection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class ExampleSetupActivity extends AppCompatActivity {

    public static Context appContext;
    static final String appId = "client_default";
    public String urlAuth = "https://waap-auth.example-waap.waap.safous.com";
    public String urlRegister = "https://waap-register.example-waap.waap.safous.com";
    public String urlVerification = "https://waap-client-verification.example-waap.waap.safous.com";
    static final String password = "examplesafous";
    public static File cert = null;
    public static ApiProtection protection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_setup);
        setSetupEnv();
    }

    public static void setSetupEnv(){
        protection = new ApiProtection(appContext.getApplicationContext());
        protection.setupEnv(appId,
                urlRegister,
                urlAuth,
                urlVerification,
                cert.getAbsolutePath(),
                password);
    }
}