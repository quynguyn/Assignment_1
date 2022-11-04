package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(getApplicationContext(), "onCreate",Toast.LENGTH_LONG).show();
        Intent i = getIntent();
        if (i.getExtras() != null){
            String response = (String)i.getExtras().get("service");
            TextView notification = (TextView) findViewById(R.id.notification);
            notification.setText("Thank you for selecting " +  response + " service.");
        }

        // Go to Emotional
        Button goToEmotional = (Button) findViewById(R.id.goToEmotional);
        goToEmotional.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                nameText = findViewById(R.id.nameText);
//                name = nameText.getText().toString();
                Intent i = new Intent(MainActivity.this, Emotional.class);
//                i.putExtra("name", name);
                startActivityForResult(i, 100);
            }
        });
        // Go to Physical
        Button goToPhysical = (Button) findViewById(R.id.goToPhysical);
        goToPhysical.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Physical.class);
                i.putExtra("requestCode","200");
                startActivityForResult(i, 200);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK){
                // Come back from Emotional, fix inside code
                if (data.getExtras().get("service") == null){
                    String response = (String)data.getExtras().get("age");
                    TextView display = (TextView) findViewById(R.id.notification);
                    display.setText("Thank you " + name + " for submitting the form. Your age is " +  response);
                }
                else {
                    // Come back from Physical, fix inside code
                    String response = (String)data.getExtras().get("service");
                    TextView notification = (TextView) findViewById(R.id.notification);
                    notification.setText("Thank you for selecting " +  response + " service.");
                }
            }
        }
        // Come back from Physical, fix inside code
        if (requestCode == 200) {
            if (resultCode == RESULT_OK){
                String response = (String)data.getExtras().get("service");
                TextView notification = (TextView) findViewById(R.id.notification);
                notification.setText("Thank you for selecting " +  response + "service.");
            }
        }
    }
}