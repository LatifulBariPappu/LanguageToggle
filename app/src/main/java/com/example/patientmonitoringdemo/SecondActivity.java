package com.example.patientmonitoringdemo;

import android.os.Bundle;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends BaseActivity {
    SwitchCompat languageToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        languageToggle = findViewById(R.id.languageToggle);
        String currentLang = LocaleHelper.getLanguage(this);
        languageToggle.setChecked(currentLang.equals("en"));

        languageToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String lang = isChecked ? "en" : "bn";
            LocaleHelper.changeLanguage(SecondActivity.this, lang);
            recreate(); // Recreate to apply new locale
        });
    }
}