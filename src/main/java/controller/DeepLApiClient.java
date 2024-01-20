package controller;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import configs.AppConfig;

public class DeepLApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeepLApiClient.class);
    private static final String API_KEY = AppConfig.getInstance().getDeepLApiKey();
    private static final String ENDPOINT = "https://api-free.deepl.com/v2/translate";

    public String translateText(String text, String targetLanguage) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String requestBody = String.format("auth_key=%s&text=%s&target_lang=%s&source_lang=DE",
                    API_KEY,
                    URLEncoder.encode(text, StandardCharsets.UTF_8.toString()),
                    URLEncoder.encode(targetLanguage, StandardCharsets.UTF_8.toString()));
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray translations = jsonResponse.getJSONArray("translations");
            String translatedText = translations.getJSONObject(0).getString("text");
            return translatedText;
        } catch (Exception e) {
            LOGGER.error("Error while creating the HTTP request or receiving the response: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
