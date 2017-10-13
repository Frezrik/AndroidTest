package com.test.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private ScrollView mSv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSv = (ScrollView) findViewById(R.id.sv);
        mTv = (TextView) findViewById(R.id.tv);

        handler.post(new Runnable() {
            @Override
            public void run() {
                mSv.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        new LogThread().start();
    }

    public final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (mTv.getLineCount() > 500) {
                        mTv.setText("");
                    }
                    mTv.append(msg.obj + "\n");

                    break;
                default:

                    break;
            }


        }
    };

    class LogThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Process process = Runtime.getRuntime().exec("logcat -v time");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String str;
                while ((str = br.readLine()) != null) {
                    if (str.contains("TestRunner"))
                        handler.obtainMessage(0, str).sendToTarget();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
