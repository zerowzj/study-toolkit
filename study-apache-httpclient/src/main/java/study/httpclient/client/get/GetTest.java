package study.httpclient.client.get;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

@Slf4j
public class GetTest {

    private String url = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        //请求参数
        URIBuilder builder = new URIBuilder(url);
        String query = "name=wangzhj&age=36";
        builder.setCustomQuery(query);
        log.info("uri: {}", builder.toString());
        HttpGet httpGet = new HttpGet(builder.build());
        //请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        //响应
        StatusLine line = response.getStatusLine();
        log.info("status line: {}", line);
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        log.info("entity: {}", body);
    }

    @Test
    public void requestConfig_test() throws Exception {
        //请求配置
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(1 * 1000)
                .setConnectTimeout(60 * 1000)
                .setSocketTimeout(60 * 1000)
//                .setProxy(null)
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        StatusLine line = response.getStatusLine();
        log.info("status line: {}", line);
    }
}
