package study.httpclient.method;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Get_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Post_Main.class);

    private static final String URL = "http://www.sohu.com";

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(URL);
            //请求头部
            httpGet.setHeader("", "");
            //请求配置
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(60 * 1000)
                    .setSocketTimeout(60 * 1000)
                    .build();
            httpGet.setConfig(config);
            //
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null);
            EntityUtils.toString(entity);

            HttpResponse response = client.execute(httpGet);
            StatusLine line = response.getStatusLine();
            LOGGER.info("{}", line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
