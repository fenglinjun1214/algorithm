import java.lang.reflect.Proxy;

public class MyProxy {

    public static void main(String[] args) {
        Subject sub = new SubjectImpl();
        SubjectInvocation invocation = new SubjectInvocation(sub);
        Subject subject = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(), sub.getClass().getInterfaces(), invocation);
        subject.sayHello("ssss");
    }
}
