package com.company.project;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

public class HttpClientUtil {

    public static void form(String url, Map<String, Object> params) {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null, "UTF-8");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);

            response.getEntity();
        } catch (IOException ex) {
        }
    }

    public static void post(String url, Map<String, Object> params) {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            client.execute(post);
        } catch (IOException ex) {
        }
    }
}
