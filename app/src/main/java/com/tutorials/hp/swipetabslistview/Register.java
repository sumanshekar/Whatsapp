package com.tutorials.hp.swipetabslistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {


        public EditText editText1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText1 = (EditText)findViewById(R.id.editText);
                    String number = editText1.getText().toString().trim();
                    if(number.isEmpty() || number.length() < 10)
                    {
                        editText1.setError("valid number please");
                        editText1.requestFocus();
                        return;

                    }
                    String pn = "+91"+number;
                    Intent intent = new Intent(Register.this, OtpActivity.class);
                    intent.putExtra("phone" , pn);
                    startActivity(intent);
                }
            });

        }

        @Override
        protected void onStart()
        {
            super.onStart();
            if(FirebaseAuth.getInstance().getCurrentUser()!=null)
            {
                Intent intent = new Intent(Register.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    }
