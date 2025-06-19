package com.example.patientmonitoringdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends BaseActivity {

    SwitchCompat languageToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.nextBtn);

        languageToggle = findViewById(R.id.languageToggle);
        String currentLang = LocaleHelper.getLanguage(this);
        languageToggle.setChecked(currentLang.equals("en"));

        languageToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String lang = isChecked ? "en" : "bn";
            LocaleHelper.changeLanguage(MainActivity.this, lang);
            recreate(); // Recreate to apply new locale
        });

        button.setOnClickListener( v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String currentLang = LocaleHelper.getLanguage(this);
        languageToggle.setChecked(currentLang.equals("en"));
    }
}