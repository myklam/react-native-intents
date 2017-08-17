
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

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
  public void concatStr(String string1, String string2, Promise promise) {
    promise.resolve(string1 + " " + string2);
  }
}