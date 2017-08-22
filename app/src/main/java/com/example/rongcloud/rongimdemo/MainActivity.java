package com.example.rongcloud.rongimdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RongCloudDemo";
    private Button joinChatBtn;
    private Button connectBtn;

    private static String mToken = "Q08OQVRU5g/fSDC8GcVlFX2djOlKdyJcYtByN4ERVqHXdBrubw+NhUFSdUjyf7GqXGG8nFhr8APCF9FPz0mM+g==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        registerListeners();
    }

    private void initWidget() {
        connectBtn = (Button) findViewById(R.id.btn_connect);
        joinChatBtn = (Button) findViewById(R.id.btn_join_chat);

        connectBtn.setOnClickListener(this);
        joinChatBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_connect: {
                connect();
                break;
            }
            case R.id.btn_join_chat: {
                joinChatRoom();
                break;
            }
        }
    }

    private void joinChatRoom() {
        RongIMClient.getInstance().joinChatRoom("111", 10, new RongIMClient.OperationCallback() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "onSuccess: join chat room");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.i(TAG, "onError: code=" + errorCode.getValue());
            }
        });
    }


    private void connect() {
        RongIMClient.connect(mToken, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.i(TAG, "Incorrect token");
            }

            @Override
            public void onSuccess(String s) {
                Log.i(TAG, "Connect successfully");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.i(TAG, "Connect error");
            }
        });
    }

    private void registerListeners() {
        RongIMClient.setOnReceiveMessageListener(new RongIMClient.OnReceiveMessageListener() {
            @Override
            public boolean onReceived(Message message, int i) {
                Log.i(TAG, "onReceived: ");
                return false;
            }
        });
    }
}
