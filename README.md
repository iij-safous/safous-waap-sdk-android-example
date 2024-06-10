# safous-waap-sdk-android-example

## Getting Started

### How to Build

1. Download the Android SDK from Admin portal. 
2. Put the SDK on libs folder 
	```
   	<project>/app/libs
   	```
3. Open Gradle file (build.gradle:app)
4. Put SDK file in dependencies
	```
   	implementation files('libs/SafousWaap.aar')
   	```

### Configuration

1. Download the certificate from Admin portal.
2. Put the certificate on raw directory.
	```
   	<project>/app/src/main/res/raw
   	```
3. Now go to ExampleSetupEnvActivity class
	- [ExampleSetupEnvTest.java#L18-L23](app/src/main/java/com/iij/androidExample/ExampleSetupActivity.java#L19-L25)
4. Modify several value in the class, set it based on your environment.
	```
   public String appId = "default"
   public String urlAuth = "https://waap-auth.example.waap.safous.com"
   public String urlRegister = "https://waap-register.example.waap.safous.com"
   public String urlVerification = "https://waap-client-verification.example.waap.safous.com"
   public File cert = Context.getResources().openRawResources(R.raw.<CERTIFICATE_NAME.p12>)
   public String password = "PASSPHRASE_FOR_CLIENT_CERTIFICATE"
   ```
5. Run the setupEnv class
	```
	Right Click on class from Android Studio, then click 'Run ExampleSetupActivity'.
	```

### How to Use
1. Open ExampleRegistrationActivity class
	- [ExampleRegisterActivity.java](app/src/main/java/com/iij/androidExample/ExampleRegisterActivity.java)
2. Run the Registration class
	```
	Right Click on class from Android Studio, Click 'Run ExampleRegistrationActivity'
	``` 
3. Open ExampleTransactionActivity class
	- [ExampleTransactionActivity.java#L21-L22](app/src/main/java/com/iij/androidExample/ExampleTransactionActivity.java#L21-L22)
4. Modify Simple and Echo url in the class
	```
   public String urlBasicApi = "https://simple-web.example.waap.safous.com/"
   public String urlEchoApi = "https://echo.example.waap.safous.com/"
   ```
5. Run the Transaction class
	```
	Right Click on class from Android Studio, Click 'Run ExampleTransactionActivity'
	``` 
