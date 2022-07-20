package com.example.staticlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity
{
    EditText username,password;
    Button login;
    TextView attempt;
    int totalAttempt=5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        attempt=findViewById(R.id.attempt);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String USERNAME=username.getText().toString();
                String PASSWORD= password.getText().toString();

                if (USERNAME.isEmpty())
                {
                    username.setError("Plase Enter the username ");
                    username.requestFocus();
                    return;
                }

                if (PASSWORD.isEmpty())
                {
                    password.setError("Plase Enter the password");
                    password.requestFocus();
                    return;
                }

                if (USERNAME.equals("admin")&& (PASSWORD.equals("12345")))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("userkey",USERNAME);
                    startActivity(intent);
                }
                else
                {
                    totalAttempt--;
                    attempt.setText(Integer.toString(totalAttempt));

                    if (totalAttempt==0)
                    {
                        login.setVisibility(View.INVISIBLE);
                    }
                }

            }
        });

    }
}