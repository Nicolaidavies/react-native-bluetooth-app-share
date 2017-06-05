
package io.nicolai;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RNBluetoothShareModule extends ReactContextBaseJavaModule {
  String TAG = "BT TRANSFER";
  Integer REQUEST_ENABLE_BT = 0;

  private final ReactApplicationContext reactContext;

  public RNBluetoothShareModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBluetoothShare";
  }

  @ReactMethod
  private void sendAPK (String fileName) {
    try {
        ApplicationInfo app = reactContext.getApplicationInfo();
        String filePath = app.sourceDir;

        File apk = new File(filePath);
        
        File outputFile = new File(reactContext.getExternalFilesDir(null), fileName + ".apk");

        copy(apk, outputFile);


        Intent intent = new Intent(Intent.ACTION_SEND);
        // MIME of .apk is "application/vnd.android.package-archive".
        // but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.setType("*/*");
        // Only use Bluetooth to send .apk
        intent.setPackage("com.android.bluetooth");
        // Append file and send Intent
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(outputFile));
        getCurrentActivity().startActivity(Intent.createChooser(intent, "Share app"));
    } catch (IOException e) {
        Log.d(TAG, e.toString());
    }
  }

  public void copy(File src, File dst) throws IOException {
    InputStream in = new FileInputStream(src);
    OutputStream out = new FileOutputStream(dst);

    // Transfer bytes from in to out
    byte[] buf = new byte[1024];
    int len;
    while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
    }
    in.close();
    out.close();
  }
}