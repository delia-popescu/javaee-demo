package cdi.interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Constructor;

@Priority(Interceptor.Priority.APPLICATION + 10)
@Interceptor
@Logging
public class LoggingInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        String name = context.getMethod().getName();
        String params = context.getMethod().getParameters().toString();

        System.out.println("From interceptor: " + name + " " + params);
        return context.proceed();
    }

    @AroundConstruct
    public void onConstruct(InvocationContext context) throws  Exception{
        Constructor constructor = context.getConstructor();
        System.out.println("COnstructor is: " + constructor);
        context.proceed();
    }
}
