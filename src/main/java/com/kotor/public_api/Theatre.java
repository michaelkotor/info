package com.kotor.public_api;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Theatre {
    private final String API_KEY = "?api_key=82cce8774e1d740003853ca2cee3b0f5";
    private final String BASE = "https://apidata.mos.ru/v1/datasets/";
    private final String ID = "498";

    private ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("a1", "a2", "a3", "a3", "a4", "a4", "a6",
            "a675",
            "765",
            "Michael"));

    public Object parse() {
        String url = BASE + ID + API_KEY;
        /*
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
         */


        return null;
    }

    public Object start() {
        return arrayList;
    }

    public Object distinct() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.distinct()
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object skip() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.skip(4)
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object filter() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        long stringCollection = streamFromCollection.filter("Michael"::equals).count();
        return stringCollection;
    }

    public Object map() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.map((s) -> s + "_1")
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object peek() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.peek(String::toUpperCase)
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object limit() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.limit(5)
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object sorted() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = streamFromCollection.sorted()
                .collect(Collectors.toList());
        return stringCollection;
    }

    public Object flatMap() {
        ArrayList<String> collection1 = (ArrayList<String>) arrayList.clone();
        Stream<String> streamFromCollection = collection1.stream();

        Collection<String> stringCollection = Arrays.asList(streamFromCollection.flatMap(
                (p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new));

        return stringCollection;
    }

    public String sendRequest() throws IOException {
        String url = BASE + ID + API_KEY;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        return convertStreamToString(connection.getInputStream());
    }

    private static String convertStreamToString(@NotNull InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
