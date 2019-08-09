package study.spi;

import java.util.ServiceLoader;

public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<IShout> services = ServiceLoader.load(IShout.class);
        for (IShout s : services) {
            s.shout();
        }
    }
}
