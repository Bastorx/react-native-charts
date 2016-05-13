package com.lib;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class Test extends ReactContextBaseJavaModule {
  public Test(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "Test";
  }


  @ReactMethod
  public void hello() {
    System.out.println("Hello World");
  }
}