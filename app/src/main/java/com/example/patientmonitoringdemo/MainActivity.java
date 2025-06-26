package com.example.patientmonitoringdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    SwitchCompat languageToggle;
    TextView languageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.nextBtn);

        languageToggle = findViewById(R.id.languageToggle);
        languageTv = findViewById(R.id.languageTv);

        String currentLang = LocaleHelper.getLanguage(this);
        languageToggle.setChecked(currentLang.equals("en"));
        languageTv.setText(currentLang.equals("en") ? "English" : "বাংলা");

        languageToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String lang = isChecked ? "en" : "bn";
            LocaleHelper.changeLanguage(MainActivity.this, lang);
            recreate(); // Recreate to apply new locale
        });

        button.setOnClickListener( v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYmJhNDhjNi00NTMyLTQyZGMtOWY5MC02YTBmYTI1NmE5MzciLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0Ojk4OTgvYXV0aC9wdWJsaWMvc2lnbi1pbiIsImZ1bGxOYW1lIjoiQXNocmFmdWwgQWxhbSIsImlzQWRtaW4iOmZhbHNlLCJpc1Rlc3RpbmdMYWIiOmZhbHNlLCJwaG9uZU51bWJlciI6Iis4ODAxOTUyODQzMjE2IiwiaXNEb2N0b3IiOmZhbHNlLCJpZCI6ImJiYmE0OGM2LTQ1MzItNDJkYy05ZjkwLTZhMGZhMjU2YTkzNyIsImV4cCI6MTc1MDAzMzIxNSwiaWF0IjoxNzUwMDA0NDE1LCJpc1BhdGllbnQiOnRydWUsImlzUGhhcm1hY3kiOmZhbHNlLCJpc0RvbmF0aW9uIjpmYWxzZX0._jxjXgXyeTyJ4EHgMl747uRV8ndmwsJvyEuMCNVSkIQ";
        JSONObject payload = JwtDecoder.decodeJWT(accessToken);

        if (payload != null) {
            String sub = payload.optString("sub");
            String iss = payload.optString("iss");
            String fullName = payload.optString("fullName");
            boolean isAdmin = payload.optBoolean("isAdmin");
            boolean isTestingLab = payload.optBoolean("isTestingLab");
            String phoneNumber = payload.optString("phoneNumber");
            boolean isDoctor = payload.optBoolean("isDoctor");
            String id = payload.optString("id");
            long exp = payload.optLong("exp");
            long iat = payload.optLong("iat");
            boolean isPatient = payload.optBoolean("isPatient");
            boolean isPharmacy = payload.optBoolean("isPharmacy");
            boolean isDonation = payload.optBoolean("isDonation");



            Log.d("MainActivity", "sub: " + sub);
            Log.d("MainActivity", "iss: " + iss);
            Log.d("MainActivity", "fullName: " + fullName);
            Log.d("MainActivity", "isAdmin: " + isAdmin);
            Log.d("MainActivity", "isTestingLab: " + isTestingLab);
            Log.d("MainActivity", "phoneNumber: " + phoneNumber);
            Log.d("MainActivity", "isDoctor: " + isDoctor);
            Log.d("MainActivity", "id: " + id);
            Log.d("MainActivity", "exp: " + exp);
            Log.d("MainActivity", "iat: " + iat);
            Log.d("MainActivity", "isPatient: " + isPatient);
            Log.d("MainActivity", "isPharmacy: " + isPharmacy);
            Log.d("MainActivity", "isDonation: " + isDonation);

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        String currentLang = LocaleHelper.getLanguage(this);
        languageTv.setText(currentLang.equals("en") ? "English" : "বাংলা");
        languageToggle.setChecked(currentLang.equals("en"));
    }
}
