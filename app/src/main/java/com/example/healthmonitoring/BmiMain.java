package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BmiMain extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_main);
        Button b=findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a=findViewById(R.id.editText);
                String a1=  a.getText().toString();
                EditText b= findViewById(R.id.editText2);
                String b1=  b.getText().toString();
                int weight=Integer.parseInt(a1);
                double height=Double.parseDouble(b1)*0.305;
                double heightSquare=height*height;
                double bmi=weight/heightSquare;
                //Toast.makeText(getApplicationContext(),"bmi is!!"+bmi,Toast.LENGTH_LONG).show();

                Intent intent=new Intent(getApplicationContext(),BmiIs.class);
                intent.putExtra("bmi",bmi);
                startActivity(intent);

            }
        });
    }
}
