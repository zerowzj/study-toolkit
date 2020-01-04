package study.apache.commons.lang3.reflect;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Father {

    private String fatherName;

    private int fatherAge;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(int fatherAge) {
        this.fatherAge = fatherAge;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://dev.ticket.xk12.cn/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        InputStream input = conn.getInputStream();

        String str = IOUtils.toString(input, "UTF-8");
        System.out.println(str);
    }
}
