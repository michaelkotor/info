package com.kotor.public_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import org.springframework.expression.spel.support.StandardTypeConverter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Theatre {
    private final String BASE = "https://api.protestby.info/api/charts";

    private ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("a1", "a2", "a3", "a3", "a4", "a4", "a6",
            "a675",
            "765",
            "Michael"));



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
        String url = BASE;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();


        connection.setRequestMethod("GET");

        return convertStreamToString(connection.getInputStream());
    }

    private static String convertStreamToString(@NotNull InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();

        String line;
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
        System.out.println(sb);
        return sb.toString();
    }

    public String generateJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("files/car.json"), car);
        return objectMapper.writeValueAsString(car);
    }


}
