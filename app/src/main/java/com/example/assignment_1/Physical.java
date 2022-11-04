package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Physical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical);

        Button buttonClean = (Button) findViewById(R.id.button2);
        buttonClean.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentService.this,
                        MainActivity.class);
                intent.putExtra("service", "Cleaning");
                Intent i = getIntent();
                if (i.getExtras() != null){
                    String signal = i.getExtras().get("requestCode").toString();
                    if (signal.equals("200")){
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
                else{
                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
                    intent2.putExtra("service", "Cleaning");
                    setResult(RESULT_OK, intent2);
                    finish();
                }
            }
        });

//
//        Button buttonTutor = (Button) findViewById(R.id.button1);
//        buttonTutor.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(StudentService.this, MainActivity.class);
//                intent.putExtra("service", "Tutoring");
//                Intent i = getIntent();
//                if (i.getExtras() != null){
//                    String signal = i.getExtras().get("requestCode").toString();
//                    if (signal.equals("200")){
//                        setResult(RESULT_OK, intent);
//                        finish();
//                    }
//                }
//                else{
//                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
//                    intent2.putExtra("service", "Tutoring");
//                    setResult(RESULT_OK, intent2);
//                    finish();
//                }
//            }
//        });


//        Button buttonTransport = (Button) findViewById(R.id.button3);
//        buttonTransport.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(StudentService.this,
//                        MainActivity.class);
//                intent.putExtra("service", "Transporting");
//                Intent i = getIntent();
//                if (i.getExtras() != null){
//                    String signal = i.getExtras().get("requestCode").toString();
//                    if (signal.equals("200")){
//                        setResult(RESULT_OK, intent);
//                        finish();
//                    }
//                }
//                else{
//                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
//                    intent2.putExtra("service", "Transporting");
//                    setResult(RESULT_OK, intent2);
//                    finish();
//                }
//            }
//        });
    }
}
