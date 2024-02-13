package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class kalkulator extends AppCompatActivity {

    EditText FieldOne;
    EditText FieldTwo;
    Spinner Operator;
    TextView ResultText;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        FieldOne = findViewById(R.id.fieldOne);
        FieldTwo = findViewById(R.id.fieldTwo);
        Calculate = findViewById(R.id.btn_calculate);
        Operator = findViewById(R.id.drpdwn_operators);
        ResultText = findViewById(R.id.txt_resultnumber);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldOne.getText().toString().equals("") || FieldTwo.getText().toString().equals(""))
               {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nomor belum lengkap!", Toast.LENGTH_LONG);
                    toast.show();
               }else
                {
                    String CurrentOperator = Operator.getSelectedItem().toString();
                    String Result = "";

                    switch(CurrentOperator)
                    {
                        case "Tambah (+)":
                            Result = Integer.toString(Integer.parseInt(FieldOne.getText().toString()) + Integer.parseInt(FieldTwo.getText().toString()));
                            break;
                        case "Kurang (-)":
                            Result = Integer.toString(Integer.parseInt(FieldOne.getText().toString()) - Integer.parseInt(FieldTwo.getText().toString()));
                            break;
                        case "Kali (x)":
                            Result = Integer.toString(Integer.parseInt(FieldOne.getText().toString()) * Integer.parseInt(FieldTwo.getText().toString()));
                            break;
                        case "Bagi (/)":
                            if(!FieldTwo.getText().toString().equals("0")) {
                                Result = Integer.toString(Integer.parseInt(FieldOne.getText().toString()) / Integer.parseInt(FieldTwo.getText().toString()));
                            }else
                            {
                                Result = "Tidak terdefinisikan!";
                                Toast toast = Toast.makeText(getApplicationContext(), "Bilangan kedua tidak boleh 0!", Toast.LENGTH_LONG);
                                toast.show();
                            }

                            break;
                    }

                    ResultText.setText(Result);
                }
            }
        });
    }
}