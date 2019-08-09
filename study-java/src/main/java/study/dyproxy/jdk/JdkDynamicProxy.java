package study.dyproxy.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.dyproxy.MyService;
import study.dyproxy.MyServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdkDynamicProxy.class);

    private Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info("before invoke");
        Object result = null;
        try {
            result = method.invoke(target, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LOGGER.info("after invoke");
        return result;
    }

    public <T> T getProxy() {
        Class clazz = target.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        Class<?>[] interfaces = clazz.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    public static void main(String[] args) {
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(new MyServiceImpl());
        MyService myService = jdkDynamicProxy.getProxy();
        System.out.println(myService.sayHi("123123"));
    }
}
