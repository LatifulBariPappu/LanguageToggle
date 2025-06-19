package com.example.patientmonitoringdemo;
import android.util.Base64;
import org.json.JSONObject;

public class JwtDecoder {

    public static JSONObject decodeJWT(String jwt) {
        try {
            // Split the JWT into Header, Payload, and Signature
            String[] parts = jwt.split("\\.");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid JWT token");
            }

            String payload = parts[1];

            // Decode base64 URL-safe payload to string
            byte[] decodedBytes = Base64.decode(payload, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
            String decodedPayload = new String(decodedBytes, "UTF-8");

            // Convert to JSON
            return new JSONObject(decodedPayload);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
