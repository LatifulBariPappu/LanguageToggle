package com.example.patientmonitoringdemo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends BaseActivity {
    SwitchCompat languageToggle;
    TextView languageTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        languageToggle = findViewById(R.id.languageToggle);
        languageTv = findViewById(R.id.languageTv);

        String currentLang = LocaleHelper.getLanguage(this);
        languageToggle.setChecked(currentLang.equals("en"));
        languageTv.setText(currentLang.equals("en") ? "English" : "বাংলা");

        languageToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String lang = isChecked ? "en" : "bn";
            LocaleHelper.changeLanguage(SecondActivity.this, lang);
            recreate(); // Recreate only
        });
    }

    // After recreation, show text again
    @Override
    protected void onResume() {
        super.onResume();
        String currentLang = LocaleHelper.getLanguage(this);
        languageTv.setText(currentLang.equals("en") ? "English" : "বাংলা");
        languageToggle.setChecked(currentLang.equals("en"));
    }

}