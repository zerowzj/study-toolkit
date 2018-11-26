package com.company.project;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    /**
     * 表单提交请求
     *
     * @param url
     * @param params
     */
    public static void form(String url, Map<String, String> params) {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            if (params != null) {
                List<NameValuePair> pairLt = new ArrayList<>();
                for (Map.Entry<String, String> param : params.entrySet()) {
                    pairLt.add(new BasicNameValuePair(param.getKey(), param.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairLt, "UTF-8");
                post.setEntity(entity);
            }
            HttpResponse response = client.execute(post);

            response.getEntity();
        } catch (IOException ex) {
        }
    }

    /**
     * 表单提交请求
     *
     * @param url
     * @param params
     */
    public static void post(String url, Map<String, Object> params) {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            client.execute(post);
        } catch (IOException ex) {
        }
    }
}
