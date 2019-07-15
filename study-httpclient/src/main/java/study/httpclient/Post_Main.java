package study.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Post_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Post_Main.class);

    private static final String URL = "http://www.sohu.com";

    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(URL);
            //请求头部
            httpPost.setHeader("", "");
            //请求配置
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(60 * 1000)
                    .setSocketTimeout(60 * 1000)
                    .build();
            httpPost.setConfig(config);
            //请求实体
            httpPost.setEntity(null);

            HttpResponse response = client.execute(httpPost);
            StatusLine line = response.getStatusLine();
            LOGGER.info("{}", line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
