package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BmiIs extends AppCompatActivity {
    public static double data;
    public void healthstatus(View view){
            Intent intent=new Intent(getApplicationContext(),HealthStatus.class);
            intent.putExtra("data",data);
            startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        float a;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_is);
        TextView textView=findViewById(R.id.textView2);
        Intent intent=getIntent();
        data=intent.getDoubleExtra("bmi",0.0);
        a=(float) data;

        textView.setText("BMI is !!!"+""+a);

    }
}
