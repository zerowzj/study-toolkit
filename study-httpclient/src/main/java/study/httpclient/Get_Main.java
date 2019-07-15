package study.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Get_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Post_Main.class);

    private static final String URL = "http://www.sohu.com";

    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet(URL);
        //头部
        httpGet.setHeader("", "");
        //请求配置
        httpGet.setConfig(null);
        HttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine line = response.getStatusLine();
            LOGGER.info("{}", line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
