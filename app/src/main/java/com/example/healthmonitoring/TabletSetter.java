package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TabletSetter extends AppCompatActivity {
    public static   String a;
    public void savetablet(View view){
        EditText editText=findViewById(R.id.editText3);
        a=editText.getText().toString();
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("a",a);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet_setter);
    }
}
