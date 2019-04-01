package com.yeeyan.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_LOGIN = 100;
    boolean logon = false;

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
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        //如果未登入，則會轉換到LoginActivity這個Login的畫面
        if(!logon){
            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);   //轉到LoginActivity畫面，並呼叫LoginActivity的onCreate()、onStart()、onResume()方法
            //startActivityForResult()用於需要「在某個Activity中得到新打開的Activity關閉後返回的資料」
            startActivityForResult(intent, REQUEST_LOGIN);  //REQUEST_LOGIN為requestCode，在此例設為100，當轉換到LoginActivity時，此值會帶給LoginActivity
            // ，當從LoginActivity回來MainActivity時，也會帶回此值
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    //當LoginActivity回到MainActivity時會自動呼叫onActivityResult()方法
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_LOGIN){   //如果傳回的requestCode是 REQUEST_LOGIN的值100，則代表是從LoginActivity回來
            if(resultCode != RESULT_OK){  //代表並非正常登入
                finish();
            }
            else{   //正常登入，則用Toast顯示登入成功訊息，並顯示從LoginActivity取得的資料
                String result = data.getStringExtra("result");  //取得LoginActivity傳回來的資料
                Toast.makeText(this, "登入成功, intent data: "+result, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
