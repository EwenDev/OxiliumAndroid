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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard_tech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard_tech);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton returnbtn = findViewById(R.id.return_btn);

        Spinner spinner = findViewById(R.id.liste_deroulante_1);
        Spinner spinner2 = findViewById(R.id.liste_deroulante_2);
        Spinner spinner3 = findViewById(R.id.liste_deroulante_3);
        Spinner spinner4 = findViewById(R.id.liste_deroulante_4);

        String[] items = new String[]{"En attente", "En cours", "Terminé"};
        String[] items2 = new String[]{ "En cours","En attente", "Terminé"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter2);
        spinner4.setAdapter(adapter);

        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);

        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnbtn.startAnimation(buttonClickAnimation);
                Intent mainactivity = new Intent(dashboard_tech.this, MainActivity.class);
                startActivity(mainactivity);
            }
        });
    }
}