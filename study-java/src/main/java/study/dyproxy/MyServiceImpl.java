package study.dyproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServiceImpl implements MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    @Override
    public String sayHi(String name) {
        LOGGER.info("this sayHi");
        return "hello, " + name;
    }
}
