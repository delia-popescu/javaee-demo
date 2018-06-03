package ejb.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class MyStatelessBean {

//    @MyAroundConstructInterceptorBinding
    public MyStatelessBean(){
        System.out.println("MyStatelessBean.constructor");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("MyStatelessBeab.postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("MyStatelessBean.preDestroy");
    }

    public void m1(){
        System.out.println("MyStatelessBean.m1");
    }
}
