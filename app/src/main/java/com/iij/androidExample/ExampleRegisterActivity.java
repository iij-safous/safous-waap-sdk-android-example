package com.iij.androidExample;

import androidx.appcompat.app.AppCompatActivity;

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
        exampleRegistration();
    }

    private void exampleRegistration() {
        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
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
        protection.registerDevice(callBack);
    }

    private void exampleVerifyDevice() {
        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
            @Override
            public void onSuccessReceived(OkHttpClient okHttpClient) {
                Log.d("Response",okHttpClient.toString());
            }
            @Override
            public void onErrorReceived(Error e) {
                Log.e("Error",e.toString());
            }
        };
        protection.verifyDevice(callBack,null);
    }
}