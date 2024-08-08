package com.iij.androidExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.safous.waap.ApiProtection;
import com.safous.waap.ApiProtectionCallBack;
import com.safous.waap.AuthCallBack;
import com.safous.waap.utilities.Error;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExampleTransactionActivity extends AppCompatActivity {

    private String urlBasicApi = "https://simple-web.example-waap.waap.safous.com/";
    private String urlEchoApi = "https://echo.example-waap.waap.safous.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_transaction);
        exampleTransactionSimpleAPI();
        exampleTransactionEchoApi();
        exampleTransactionTerminate();
    }

    private ApiProtection protection;
    public void exampleTransactionSimpleAPI() {
        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
            @Override
            public void onSuccessReceived(OkHttpClient okHttpClient) {
                Request request = new Request.Builder().url(urlBasicApi).get().build();

                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        Log.d("State",response.body().toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onErrorReceived(Error e) {
                Log.e("Error",e.toString());
            }
        };
        protection.transaction(callBack);
    }

    public void exampleTransactionEchoApi() {
        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
            @Override
            public void onSuccessReceived(OkHttpClient okHttpClient) {
                Request request = new Request.Builder().url(urlEchoApi).get().build();

                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        Log.d("State",response.body().toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onErrorReceived(Error e) {
                Log.e("Error",e.toString());
            }
        };
        protection.transaction(callBack);
    }

    public void exampleTransactionTerminate() {
        AuthCallBack<Object> callBack = new AuthCallBack<Object>() {
            @Override
            public void onSuccessReceived(Object object) {
                Log.d("Success",object.toString());
            }

            @Override
            public void onErrorReceived(Error e) {
                Log.e("Error",e.toString());
            }
        };
        protection.terminate(callBack);
    }
}