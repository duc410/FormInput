package com.example.forminput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstName,lastName,birthDay,address,email;
    RadioGroup radioGroup;
    CheckBox checkBox;
    Button button;
    StringBuilder firstPart = new StringBuilder("");
    String finalPart="còn trống";
    StringBuilder msg = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName=findViewById(R.id.editTxtFirstName);
        lastName=findViewById(R.id.editTxtLastName);
        birthDay=findViewById(R.id.editTextBirthDay);
        address=findViewById(R.id.editTextAddress);
        email=findViewById(R.id.editTextEmail);
        radioGroup=findViewById(R.id.radioGroup);
        checkBox=findViewById(R.id.checkBox);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty(firstName)){
                    firstName.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    firstName.requestFocus();
                    firstPart.append("First Name,");
                }else {
                    firstName.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(isEmpty(lastName)){
                    lastName.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    lastName.requestFocus();
                    firstPart.append("Last Name,");
                }else{
                    lastName.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    radioGroup.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    radioGroup.requestFocus();
                    firstPart.append("Gender,");
                }else{
                    radioGroup.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(isEmpty(birthDay)){
                    birthDay.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    birthDay.requestFocus();
                    firstPart.append("Birthday,");
                }else{
                    birthDay.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(isEmpty(address)){
                    address.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    address.requestFocus();
                    firstPart.append("Address,");
                }else{
                    address.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(isEmpty(email)){
                    email.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    email.requestFocus();
                    firstPart.append("Email,");
                }else{
                    email.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(!checkBox.isChecked()){
                    checkBox.setBackground(getResources().getDrawable(R.drawable.edit_text_warn));
                    checkBox.requestFocus();
                    firstPart.append("CheckBox,");
                }else{
                    checkBox.setBackground(getResources().getDrawable(R.drawable.edit_text));
                }

                if(firstPart.length()>0){
                    msg.append(firstPart);
                    msg.append(finalPart);
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
                    firstPart.setLength(0);
                    msg.setLength(0);
                }
                
            }
        });
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}