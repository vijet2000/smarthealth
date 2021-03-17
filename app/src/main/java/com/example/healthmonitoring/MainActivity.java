package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void noti(View view){
        Intent intent=new Intent(this,TabletSetter.class);
        startActivity(intent);
    }
    public void bmistart(View view){
        Intent intent=new Intent(this,BmiMain.class);
        startActivity(intent);
    }
    public void memo(View view){
        Intent intent=new Intent(getApplicationContext(),Memo.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
