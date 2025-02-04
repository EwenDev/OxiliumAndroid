package com.chokbar.oxilium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton returnbtn = findViewById(R.id.return_btn2);
        Button createTicketBtn = findViewById(R.id.createTicketButton);

        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);

        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra("concerne") != null){
            String concerne = intent.getStringExtra("concerne") + " > ";
            String description = intent.getStringExtra("description");

            TextView ticket1User = findViewById(R.id.attribution_ticket);
            TextView ticket1Desc = findViewById(R.id.intitule);

            ticket1User.setText(concerne);
            ticket1Desc.setText(description);
        }

        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnbtn.startAnimation(buttonClickAnimation);
                Intent mainactivity = new Intent(dashboard_user.this, MainActivity.class);
                startActivity(mainactivity);
            }
        });

        createTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTicketBtn.startAnimation(buttonClickAnimation);
                Intent ticket_creation = new Intent(dashboard_user.this, ticket_creation.class);
                startActivity(ticket_creation);
            }
        });
    }
}