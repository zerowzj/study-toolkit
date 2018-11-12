import java.net.InetAddress;

public class LocalHost {

    public static void main(String[] args) {
        System.out.println("================");
        try {
            System.out.println("==> " + hostName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("================");
    }

    public static String getLocalName() {
        String hostName;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName();
        } catch (Exception ex) {
            hostName = "";
        }
        return hostName;
    }

    private static String hostName = getLocalName();
}
