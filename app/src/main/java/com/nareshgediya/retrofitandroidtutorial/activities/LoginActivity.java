package com.nareshgediya.retrofitandroidtutorial.activities;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.Login2Response;
import com.nareshgediya.retrofitandroidtutorial.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextEmail;
    private EditText editTextPassword;
    public static String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.textViewRegister).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isUserLoggedIn()) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        Call<Login2Response> call = RetrofitClient
                .getInstance().getApi().userLogin(email, password);

        call.enqueue(new Callback<Login2Response>() {
            @Override
            public void onResponse(Call<Login2Response> call, Response<Login2Response> response) {
                Login2Response loginResponse = response.body();


                if (loginResponse.getFlag() == 1) {
                    Login2Response login2Response = new Login2Response();
                    login2Response.setData(loginResponse.getData());

                    SharedPrefManager.getInstance(LoginActivity.this)
                            .saveUserdata(loginResponse.getData());

                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Log.d(TAG, "" + loginResponse.getFlag());
                    Log.d(TAG, login2Response.getData().getMobile());


                } else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMsg(), Toast.LENGTH_LONG).show();
                    Log.d(TAG, loginResponse.getMsg());
                }
            }

            @Override
            public void onFailure(Call<Login2Response> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                userLogin();
                break;
            case R.id.textViewRegister:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
