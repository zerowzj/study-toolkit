package study.httpclient.entity;

import org.apache.http.entity.StringEntity;

public class StringEntity_Main {

    public static void main(String[] args) {
        try {
            StringEntity entity = new StringEntity("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
