package com.example.healthmonitoring;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class HealthStatus extends AppCompatActivity {

    public double data;
    public static int a;
    public void Dietsuggestion(View view){
        Intent intent=new Intent(getApplicationContext(),DietSuggestion.class);
        intent.putExtra("a",a);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        ImageView imageView=findViewById(R.id.key);
        Intent intent=getIntent();
        data=intent.getDoubleExtra("data",0.0);
        TextView textView=findViewById(R.id.textView3);
        if(data<=18.5){
            textView.setText("UNDER WEIGHT");
             imageView.setImageResource(R.drawable.underw);
             imageView.animate().alpha(1f);
             a=1;
        }else if(data>18.5&&data<=24.9){
            textView.setText("NORMAL");
             imageView.setImageResource(R.drawable.normal);
             imageView.animate().rotation(360).alpha(1f);
            a=2;
        }else if(data>25&&data<=29.9){
            textView.setText("OVER WEIGHT");
             imageView.animate().alpha(1f);
            a=3;
        }else {
            textView.setText("OBESE");
            imageView.animate().alpha(1f);
            a=4;
        }
    }
}
