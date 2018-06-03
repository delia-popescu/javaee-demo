package jaxws.helloworld;

import javax.jws.WebService;

@WebService
public class Hello {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}