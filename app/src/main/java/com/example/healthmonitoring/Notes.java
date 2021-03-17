package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class Notes extends AppCompatActivity {
    int noteID;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes2);
        EditText editText=findViewById(R.id.editText4);
        Intent intent=getIntent();
        noteID=intent.getIntExtra("noteId",-1);
         if(noteID!=-1){
             editText.setText(Memo.notes.get(noteID));
         }else {
             Memo.notes.add("");
             noteID=Memo.notes.size()-1;
             Memo.arrayAdapter.notifyDataSetChanged();
         }
         editText.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                     Memo.notes.set(noteID, String.valueOf(charSequence));
                     Memo.arrayAdapter.notifyDataSetChanged();
                     SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("", Context.MODE_PRIVATE);
                     HashSet<String> set = new HashSet<>(Memo.notes);
                     sharedPreferences.edit().putStringSet("notes", set).apply();



             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

    }
}
