package study.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Post_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Post_Main.class);

    private static final String URL = "http://www.sohu.com";

    public static void main(String[] args) {
        HttpPost httpPost = new HttpPost(URL);
        //头部
        httpPost.setHeader("", "");
        //请求配置
        httpPost.setConfig(null);
        //请求实体
        httpPost.setEntity(null);

        HttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(httpPost);
            StatusLine line = response.getStatusLine();
            LOGGER.info("{}", line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
