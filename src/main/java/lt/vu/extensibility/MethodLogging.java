package lt.vu.extensibility;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@LoggingInvocation
public class MethodLogging {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println("Called method: " + context.getMethod().getName());
        return context.proceed();
    }
}
