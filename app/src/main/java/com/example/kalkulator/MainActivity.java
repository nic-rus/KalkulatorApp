package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String UsernameKey = "nico";
    String PasswordKey = "160508ok";
    String LastPassword;
    EditText UsernameBox;
    EditText PasswordBox;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameBox = findViewById(R.id.fieldOne);
        PasswordBox = findViewById(R.id.fieldTwo);
        PasswordBox.setInputType(129);
        CheckBox PasswordCheckBox = findViewById(R.id.checkPassword);
        PasswordCheckBox.setChecked(true);

        PasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    PasswordBox.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    PasswordBox.setInputType(129);
                }
            }
        });

        LoginButton = findViewById(R.id.btn_login);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UsernameBox.getText().toString().equals(UsernameKey) && PasswordBox.getText().toString().equals(PasswordKey))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Berhasil!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this, kalkulator.class);
                    startActivity(intent);
                }else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}