package com.company.project;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * 表单请求
     *
     * @param url
     * @param params
     */
    public static void form(String url, Map<String, String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);
            if (params != null) {
                List<NameValuePair> pairLt = new ArrayList<>();
                for (Map.Entry<String, String> param : params.entrySet()) {
                    pairLt.add(new BasicNameValuePair(param.getKey(), param.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairLt, CHARSET_UTF_8);
                post.setEntity(entity);
            }
            HttpResponse response = client.execute(post);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(client);
        }
    }

    /**
     * 请求
     *
     * @param url
     * @param raw
     */
    public static void post(String url, String raw) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            if (raw != null) {
                StringEntity entity = new StringEntity(raw, CHARSET_UTF_8);
                post.setEntity(entity);
            }
            HttpResponse response = client.execute(post);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(client);
        }
    }

    /**
     * 请求
     *
     * @param url
     * @param params
     */
    public void get(String url, Map<String, String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            if (params != null) {
                StringBuilder sb = new StringBuilder("&");
                for (Map.Entry<String, String> param : params.entrySet()) {
                    sb.append(param.getKey()).append("=").append(param.getValue());
                }
            }
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(client);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
