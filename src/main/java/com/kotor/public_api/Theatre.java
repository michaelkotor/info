package com.kotor.public_api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Theatre {
    private final String API_KEY = "82cce8774e1d740003853ca2cee3b0f5";
    private final String BASE = "https://apidata.mos.ru/v1/datasets/";
    private final String ID = "498";

    public Gson parse() throws IOException {
        String url = "http://www.google.com/";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        /*
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

         */

        Gson gson = new Gson();
        gson.toJson(connection.getInputStream());
        return null;
    }
}
