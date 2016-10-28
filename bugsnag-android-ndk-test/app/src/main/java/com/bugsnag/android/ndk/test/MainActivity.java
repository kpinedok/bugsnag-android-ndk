package com.bugsnag.android.ndk.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.bugsnag.android.Bugsnag;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.ndk.BugsnagObserver;


public class MainActivity extends Activity {
    static {
        System.loadLibrary("jni-entry-point");
    }
    public native void causeFpe();
    public native void causeNpe();
    public native void causeBus();
    public native void causeAbort();
    public native void causeTrap();
    public native void causeIll();
    public native void causeCppFpe();
    public native void causeCppNpe();
    public native void causeCppBus();
    public native void causeCppAbort();
    public native void causeCppTrap();
    public native void causeCppIll();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BugsnagObserver ob = new BugsnagObserver();

        Configuration config = new Configuration("c8f000122272e15e5f06e31d540cc79c");
        config.setEndpoint("http://10.0.2.2:8000");//"http://notify.bugsnag.com");

        Bugsnag.init(this, config);

        Bugsnag.getMetaData().addToTab("tab1", "Key1", "StringValue");
        Bugsnag.getMetaData().addToTab("tab1", "Key2", 23);

        Bugsnag.getMetaData().addToTab("tab2", "Key1", "StringValue");
        Bugsnag.getMetaData().addToTab("tab2", "Key2", 23);

        // Set the user information
        Bugsnag.setUser("123456", "james@example.com", "James Smith");

        Button clickButton = (Button) findViewById(R.id.notifyButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bugsnag.getClient().notify(new RuntimeException("test notify"));
            }
        });

        clickButton = (Button) findViewById(R.id.fpeButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeFpe();
            }
        });

        clickButton = (Button) findViewById(R.id.npeButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeNpe();
            }
        });

        clickButton = (Button) findViewById(R.id.busButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeBus();
            }
        });

        clickButton = (Button) findViewById(R.id.abortButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeAbort();
            }
        });

        clickButton = (Button) findViewById(R.id.trapButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeTrap();
            }
        });

        clickButton = (Button) findViewById(R.id.illButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeIll();
            }
        });


        clickButton = (Button) findViewById(R.id.cppFpeButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppFpe();
            }
        });

        clickButton = (Button) findViewById(R.id.cppNpeButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppNpe();
            }
        });

        clickButton = (Button) findViewById(R.id.cppBusButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppBus();
            }
        });

        clickButton = (Button) findViewById(R.id.cppAbortButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppAbort();
            }
        });

        clickButton = (Button) findViewById(R.id.cppTrapButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppTrap();
            }
        });

        clickButton = (Button) findViewById(R.id.cppIllButton);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                causeCppIll();
            }
        });

    }
}
