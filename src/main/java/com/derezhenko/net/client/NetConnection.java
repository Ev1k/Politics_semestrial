package com.derezhenko.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class NetConnection implements HttpClient{

    @Override
    public String get(String url, Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            URL urlStr = new URL(url);
            if (!params.isEmpty()) {
                urlStr = new URL(url + "?" + params.keySet().toArray()[0] + "=" + params.values().toArray()[0] + "&" + params.keySet().toArray()[1] + "=" + params.values().toArray()[1]);
            }
            HttpURLConnection connection = (HttpURLConnection) urlStr.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String input;
                while ((input = br.readLine()) != null) {
                    stringBuilder.append(input);
                }
//                System.out.println(stringBuilder);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        return stringBuilder.toString();
    }

    @Override
    public String post(String url, Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            URL urlStr = new URL(url);
            HttpURLConnection postConnection = (HttpURLConnection) urlStr.openConnection();

            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setRequestProperty("Accept", "application/json");
            postConnection.setRequestProperty("Authorization", "Bearer c93c5b88dfc23701e7a623b35df72b9b97ae8c78df6472fb0f0adcb32e663774");

            postConnection.setDoOutput(true);

            //вот так работает
            String jsonInput = "{\"name\":\"Tesdfgfgfgdhfhfhfgfgfhftg Test\",\"email\":\"gfgfgfffffhfhfhfdgfh  ffffg@gfh.ru\",\"gender\":\"female\",\"status\":\"active\"}";
            try (OutputStream os = postConnection.getOutputStream()) {
                byte [] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            System.out.println(postConnection.getResponseCode());

            try (BufferedReader br = new BufferedReader(new InputStreamReader(postConnection.getInputStream()))){
                String inp;
                while ((inp = br.readLine()) != null) {
                    stringBuilder.append(inp);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    @Override
    public String put(String url, Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            URL urlStr = new URL(url);
            HttpURLConnection putConnection = (HttpURLConnection) urlStr.openConnection();

            putConnection.setRequestMethod("PUT");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setRequestProperty("Accept", "application/json");
            putConnection.setRequestProperty("Authorization", "Bearer c93c5b88dfc23701e7a623b35df72b9b97ae8c78df6472fb0f0adcb32e663774");

            putConnection.setDoOutput(true);

            String jsonInput = "{\"name\":\"T Test\",\"email\":\"fffg@gfh.ru\",\"status\":\"active\"}";

            try (OutputStream os = putConnection.getOutputStream()) {
                byte [] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            System.out.println(putConnection.getResponseCode());

            try (BufferedReader br = new BufferedReader(new InputStreamReader(putConnection.getInputStream()))){
                String inp;
                while ((inp = br.readLine()) != null) {
                    stringBuilder.append(inp);
                }
//                System.out.println(stringBuilder);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    @Override
    public String delete(String url, Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            URL urlStr = new URL(url);
            HttpURLConnection deleteConnection = (HttpURLConnection) urlStr.openConnection();

            deleteConnection.setRequestMethod("DELETE");
            deleteConnection.setRequestProperty("Content-Type", "application/json");
            deleteConnection.setRequestProperty("Accept", "application/json");
            deleteConnection.setRequestProperty("Authorization", "Bearer c93c5b88dfc23701e7a623b35df72b9b97ae8c78df6472fb0f0adcb32e663774");

            deleteConnection.setDoOutput(true);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(deleteConnection.getInputStream()))){
                String inp;
                while ((inp = br.readLine()) != null) {
                    stringBuilder.append(inp);
                }
//                System.out.println(stringBuilder);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        NetConnection nc = new NetConnection();

        //get
        HashMap<String, String> pagesMap = new HashMap<>();
        pagesMap.put("page", "1");
        pagesMap.put("per_page", "2");
        System.out.println(nc.get("https://gorest.co.in/public/v2/users", pagesMap));

        //post
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put("name", "Azazfdfddffda Zaza");
        newUser.put("email", "afdfdz@jfhdf.rtr");
        newUser.put("gender", "male");
        newUser.put("status", "active");
        System.out.println(nc.post("https://gorest.co.in/public/v2/users", newUser));
    }
}
