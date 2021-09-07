import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocation implements InvocationHandler {

    private Object subject;

    public SubjectInvocation(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(subject, args);

        return "ssss";
    }
}
