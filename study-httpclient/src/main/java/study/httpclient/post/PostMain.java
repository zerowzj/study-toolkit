package study.httpclient.post;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostMain.class);

    private static final String URL = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
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
    }
}
