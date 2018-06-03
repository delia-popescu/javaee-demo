package ejb.lifecycle;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Priority(Interceptor.Priority.APPLICATION)
@Interceptor
@MyAroundConstructInterceptorBinding
public class MyAroundConstructInterceptor {

    @AroundConstruct
    public void validateConstructor(InvocationContext context) {
        System.out.println("MyAroundConstructInterceptor.validateConstructor");
        System.out.println(context.getConstructor());
        System.out.println(context.getContextData());
    }
}
