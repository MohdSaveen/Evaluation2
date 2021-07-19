package com.example.evaluationcoding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private EditText edittext1;
private EditText editText2;
private Button btnLogin;
private CheckBox checkBox;
private final String validEmail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        btnLogin=findViewById(R.id.btn1);
        checkBox=findViewById(R.id.checkbox1);
        checkBox.setOnClickListener(v -> {
            String Email=edittext1.getText().toString();
            String pswrd=editText2.getText().toString();

            SharedPreferences shrd=getSharedPreferences("demo",MODE_PRIVATE);
            SharedPreferences.Editor editor=shrd.edit();
            editor.putString("str1",Email);
            editor.putString("str2",pswrd);
            editor.apply();
        });
        btnLogin.setOnClickListener(v-> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            if(edittext1.getText().toString().matches(validEmail)&&editText2.getText().toString().length()>6){
                startActivity(intent);
            }else if(!edittext1.getText().toString().matches(validEmail)){
                edittext1.setError("Invalid Email");
            }else if(editText2.getText().toString().length()<6){
                editText2.setError("Password is very short");
            }
        });
        SharedPreferences getShared=getSharedPreferences("demo",MODE_PRIVATE);
        String value=getShared.getString("str1","");
        String value2=getShared.getString("str2","");
        edittext1.setText(value);
        editText2.setText(value2);
    }

}