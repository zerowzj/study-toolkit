import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class LocalHost {
    private static String hostName = getLocalName();

    public static void main(String[] args) {
        System.out.println("================");
        try {
            System.out.println("hostName=" + hostName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("================");
        while (true){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ex){

            }
            System.out.println("sdfsdf");
        }
    }

    public synchronized static String getLocalName() {
        String hostName;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName();
        } catch (Exception ex) {
            hostName = "";
        }
        return hostName;
    }
}
