package com.iij.androidExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.safous.waap.ApiProtection;
import com.safous.waap.ApiProtectionCallBack;
import com.safous.waap.utilities.Error;

import okhttp3.OkHttpClient;

public class ExampleRegisterActivity extends AppCompatActivity {

    private ApiProtection protection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_register);
        protection = new ApiProtection(getApplicationContext());
        exampleRegistration();
    }

    private void exampleRegistration() {
        try {
            ApiProtectionCallBack registerCallBack = new ApiProtectionCallBack() {
                @Override
                public void onSuccessReceived(OkHttpClient okHttpClient) {
                    Log.d("Response",okHttpClient.toString());
                    exampleVerifyDevice();
                }
                @Override
                public void onErrorReceived(Error e) {
                    Log.e("Error",e.toString());
                }
            };
            protection.registerDevice(registerCallBack);
        } catch(Exception e) {
            Log.e("Error",e.toString());
        }

    }

    private void exampleVerifyDevice() {
        try {
            ApiProtectionCallBack verifyCallBack = new ApiProtectionCallBack() {
                @Override
                public void onSuccessReceived(OkHttpClient okHttpClient) {
                    Log.d("Response",okHttpClient.toString());
                    setNextTransaction();
                }
                @Override
                public void onErrorReceived(Error e) {
                    Log.e("Error",e.toString());
                }
            };
            protection.verifyDevice(verifyCallBack,null);
        } catch(Exception e) {
            Log.e("Error",e.toString());
        }
    }

    public void setNextTransaction(){
        Intent i = new Intent(getApplicationContext(), ExampleTransactionActivity.class);
        startActivity(i);
    }
}