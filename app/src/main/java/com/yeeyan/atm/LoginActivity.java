package com.yeeyan.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText edUserid;
    private EditText edPasswd;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate: ");

        edUserid = findViewById(R.id.userid);
        edPasswd = findViewById(R.id.passwd);
    }

    public void login(View view){
        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();

        Intent data = new Intent();
        data.putExtra("result", "yeeyan");

        if("jack".equals(userid) && "1234".equals(passwd)){
            setResult(RESULT_OK, data);  //設定ResultCode的值為常數RESULT_OK，data的值為intent物件data，其內部夾帶著yeeyan這個字串資料
            finish();  //結束此Activity，而如果此Activity是被某個Activity呼叫，則會回到上一個呼叫他的Activity，回到該Activity後並不會呼叫他的onCreate()方法
            // ，而是呼叫onRestart()方法;
        }
    }

    public void quit(View view){

    }
}
