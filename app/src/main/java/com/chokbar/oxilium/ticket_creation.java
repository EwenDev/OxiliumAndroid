package com.chokbar.oxilium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ticket_creation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ticket_creation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button validate = findViewById(R.id.btn_validate);
        TextView missingContent = findViewById(R.id.missing_content);
        EditText concerneEditText = findViewById(R.id.et_concerne);
        EditText descriptionEditText = findViewById(R.id.et_description_demande);

        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        ImageButton goback = findViewById(R.id.return_btn);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClickAnimation);
                String concerne = concerneEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                if(concerne.isEmpty() || description.isEmpty()) {
                    missingContent.setVisibility(View.VISIBLE);
                } else {
                    Intent dashboard_user = new Intent(ticket_creation.this, dashboard_user.class);
                    dashboard_user.putExtra("concerne",concerne);
                    dashboard_user.putExtra("description",description);
                    startActivity(dashboard_user);
                }
            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback.startAnimation(buttonClickAnimation);
                Intent dashboard_user = new Intent(ticket_creation.this, dashboard_user.class);
                startActivity(dashboard_user);
            }
        });
    }

}