package com.chokbar.oxilium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button validate = findViewById(R.id.btn_validate);
        TextView wrongPass = findViewById(R.id.wrongpass);
        EditText loginEditText = findViewById(R.id.et_login);
        EditText passwordEditText = findViewById(R.id.et_password);

        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClickAnimation);
                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(login.isEmpty() && password.isEmpty()) {
                    wrongPass.setVisibility(View.VISIBLE);
                    return;
                }
                // Technician logins
                if(login.equals("oxilium.tech") && password.equals("oxilium.passwordt")) {
                    wrongPass.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this, dashboard_tech.class);
                    startActivity(intent);

                } else if(login.equals("oxilium.user") && password.equals("oxilium.passwordu")) {
                    wrongPass.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this, dashboard_user.class);
                    startActivity(intent);
                } else {
                    wrongPass.setVisibility(View.VISIBLE);
                    return;
                }
            }
        });
    }
}