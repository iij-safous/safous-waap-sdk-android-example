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
    static final String urlRegister = "https://waap-register.demo.safous.com";
    static final String urlAuth = "https://waap-auth.demo.safous.com";
    static final String urlVerification = "https://waap-verification.demo.safous.com/api/devices/verify";
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