package hu.xannosz.veneos.demo;

public class App {
    public static void main(String[] args) throws Exception {
        // keytool -genkeypair -keyalg RSA -alias selfsigned -keystore testkey.jks
        // -storepass password -validity 360 -keysize 2048

        // keytool -genkeypair -keyalg RSA -alias selfsigned -keystore keystore.jks
        // -storepass password
        // -dname "CN=localhost, OU=Developers, O=Bull Bytes, L=Linz, C=AT"

        // keytool -genkeypair -keyalg RSA -alias selfsigned -keystore keyStore.jks -storepass keyStorePassword -validity 360 -keysize 2048
    }
}
