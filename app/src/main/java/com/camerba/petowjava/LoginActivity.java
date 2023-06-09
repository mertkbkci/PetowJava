package com.camerba.petowjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;
    private TextView mPleaseWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mPleaseWait = (TextView) findViewById(R.id.pleasewait);
        mEmail = (EditText) findViewById(R.id.input_email);
        mPassword = (EditText)  findViewById(R.id.input_password);
        mContext = LoginActivity.this;
        Log.d(TAG, "onCreate: started");

        mPleaseWait.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);

        init();
        setupFirebaseAuth();
    }

    private boolean isStringNull(String string){
        Log.d(TAG, "isStringNull: checking string");

        if (string.equals("")){
            return true;
        }else {
            return false;
        }
    }
    private void init(){
        Button btnLogin = (Button)  findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to log in");

                String email = mEmail.getText().toString();
                String password =mPassword.getText().toString();

                if (isStringNull(email) && isStringNull(password)){
                    Toast.makeText(mContext,"Tüm alanları doldurmalısınız",Toast.LENGTH_SHORT).show();

                }else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "onComplete: onCompleted" + task.isSuccessful());
                                if (!task.isSuccessful()){
                                    Log.w(TAG, "signInwithEmail:Failed",task.getException() );
                                    Toast.makeText(mContext,R.string.auth_failed,Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(mContext,R.string.auth_success,Toast.LENGTH_SHORT).show();
                                    mProgressBar.setVisibility(View.GONE);
                                    mProgressBar.setVisibility(View.GONE);
                                }
                            }
                        });
                }
            }
        });

    }
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up");
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    //user is signed in
                    Log.d(TAG, "onAuthStateChanged: signed in" + user.getUid());
                }else {
                    //user is signed out
                    Log.d(TAG, "onAuthStateChanged: signed out");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}