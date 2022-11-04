package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Emotional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String nameValue;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotional);

//        Intent i = getIntent();
//        nameValue = (String) i.getExtras().get("name");
//        EditText nameText = (EditText) findViewById(R.id.nameForm);
//        nameText.setText(nameValue);


        // Back to Main, fix code inside
        Button buttonMain = (Button) findViewById(R.id.backToMain);
        buttonMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emotional.this, MainActivity.class);
//                EditText ageText = (EditText) findViewById(R.id.ageForm);
//                String ageValue = ageText.getText().toString();
//                intent.putExtra("age", ageValue);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // Go to Activity
        Button goToActivity = (Button) findViewById(R.id.goToActivity);
        goToActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emotional.this, Physical.class);
                startActivityForResult(intent, 300);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            if (resultCode == RESULT_OK){
                String response = (String)data.getExtras().get("service");
                Intent intent = new Intent(Emotional.this, MainActivity.class);
                intent.putExtra("service", response);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}