# safous-waap-sdk-android-example

## Getting Started

### How to Build

1. Download the Android SDK from Admin portal. 
2. Put the SDK on libs folder 
	```
   	<project>/app/libs
   	```

### Configuration

1. Go to ExampleSetupActivity class. Get the example path for configurating .ini parser in Admin Portal.
	- [ExampleSetupActivity.java#L24](app/src/main/java/com/iij/androidExample/ExampleSetupActivity.java#L24)
	```
   	String path = appContext.getApplicationContext().getFilesDir().getAbsolutePath();
   	```
2. Download the certificate and safouswaap.ini file from Admin portal. It needs a certificate passphrase and path to configure.
	```
	Passphrase : <pass_for_certificate>
	Path : /data/user/0/com.iij.androidExample/files/<certificate_name>.p12
	```
3. Put the certificate and safouswaap.ini file Assets directory.
	```
   	<project>/app/src/main/assets
   	```

### How to Use
1. Open ExampleTransactionActivity class
	- [ExampleTransactionActivity.java#L21-L22](app/src/main/java/com/iij/androidExample/ExampleTransactionActivity.java#L21-L22)
2. Modify Simple and Echo url in the class
	```
   private String urlBasicApi = "https://simple-web.example-waap.waap.safous.com/"
   private String urlEchoApi = "https://echo.example-waap.waap.safous.com/get?aaa=bbb"
   	```
3. Build and Run Project
	```
	Go to task bar. Click Run.
	``` 
