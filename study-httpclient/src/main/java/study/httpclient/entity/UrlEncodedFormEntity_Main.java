package study.httpclient.entity;

import org.apache.http.client.entity.UrlEncodedFormEntity;

public class UrlEncodedFormEntity_Main {

    public static void main(String[] args) {
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
