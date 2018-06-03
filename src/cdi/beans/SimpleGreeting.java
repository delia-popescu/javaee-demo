package cdi.beans;

import cdi.interceptors.Logging;

import javax.inject.Named;

@Logging
@Named("simple")
public class SimpleGreeting implements  Greeting {

    public SimpleGreeting(){
        System.out.println("Simple Greeting constructor");
    }


    @Override
    public void greet(String name) {
        System.out.println("Hello "+ name);
    }
}
