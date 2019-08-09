package study.dyproxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.dyproxy.MyService;
import study.dyproxy.MyServiceImpl;

import java.lang.reflect.Proxy;

public class CglibDynamicProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(CglibDynamicProxy.class);

    private Object target;

    public CglibDynamicProxy(Object target) {
        this.target = target;
    }


    public <T> T getProxy() {
        return null;
    }

    public static void main(String[] args) {
        CglibDynamicProxy jdkDynamicProxy = new CglibDynamicProxy(new MyServiceImpl());
        MyService myService = jdkDynamicProxy.getProxy();
        System.out.println(myService.sayHi("123123"));
    }
}
