package com.example.danielnguyen_todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editTextItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTextItem = findViewById(R.id.editTextItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit your To Do");

        editTextItem.setText(getIntent().getStringExtra(MainActivity.KEY_FROM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create an intent that has the modified text/result
                Intent intent = new Intent();
                //Pass the new edit
                intent.putExtra(MainActivity.KEY_FROM_TEXT, editTextItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //Set the intent
                setResult(RESULT_OK, intent);
                //Finish activity and go back
                finish();

            }
        });

    }
}