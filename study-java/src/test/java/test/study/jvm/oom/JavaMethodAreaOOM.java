package test.study.jvm.oom;

/**
 * 方法区
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM {

    static class OOMObject {
    }

    public static void main(final String[] args) {
        while (true) {
//            Enhancer enhancer  = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                @Override
//                public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                    return methodProxy.invokeSuper(object, objects);
//                }
//            });
//            enhancer.create();
        }
    }
}
