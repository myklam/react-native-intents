
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.content.Intent;
import android.app.Activity;

public class RNIntentsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNIntentsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNIntents";
  }

  @ReactMethod
  public void launchIntent(String action, String category) {
    Intent i = new Intent(action);

    if (category != null) {
      i.addCategory(category);
    }
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    reactContext.startActivity(i);
  }

  @ReactMethod
  public void launchIntentAndKillActivity(String action, String category) {
    Activity activity = getCurrentActivity();
    Intent i = new Intent(action);


    if (category != null) {
      i.addCategory(category);
    }
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    reactContext.startActivity(i);
    if (activity != null) {
      activity.finishAndRemoveTask();
    }
  }
}