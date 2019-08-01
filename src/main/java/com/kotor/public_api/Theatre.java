package com.kotor.public_api;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Theatre {
    private final String API_KEY = "?api_key=82cce8774e1d740003853ca2cee3b0f5";
    private final String BASE = "https://apidata.mos.ru/v1/datasets/";
    private final String ID = "498";

    public String parse() throws IOException {
        String url = BASE + ID + API_KEY;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return stringBuilder.toString();
    }
}
