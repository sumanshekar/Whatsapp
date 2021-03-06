package com.tutorials.hp.swipetabslistview;

import android.widget.EditText;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {
    private String verificationid;
    private FirebaseAuth mAuth;
    public EditText editText1;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);
        editText1 = (EditText) findViewById(R.id.editText);
        mAuth = FirebaseAuth.getInstance();
        String pn=getIntent().getStringExtra("phone");
        sendVerificationCode(pn);

        findViewById(R.id.buttonSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editText1.getText().toString().trim();
                if(code.isEmpty() ||code.length() < 6)
                {
                    editText1.setError("valid number please");
                    editText1.requestFocus();
                    return;

                }


                verifyCode(code);

            }
        });
    }

    private  void verifyCode(String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid, code);
        signInwithCredential(credential);

    }
    public  void signInwithCredential(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent intent = new Intent(OtpActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {

                    Toast.makeText(OtpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }


        });
    }
    private void sendVerificationCode(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
                        super.onCodeSent(s, forceResendingToken);
                        verificationid=s;
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        String code =  phoneAuthCredential.getSmsCode();
                        if(code!=null)
                        {
                            progressBar.setVisibility(View.VISIBLE);
                            verifyCode(code);
                        }
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(OtpActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

/*public PhoneAuthProvider.OnVerificationStateChangedCallbacks
        mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
        super.onCodeSent(s, forceResendingToken);
        verificationid=s;
    }

    @Override
    public void onVerification
};
*/

}
