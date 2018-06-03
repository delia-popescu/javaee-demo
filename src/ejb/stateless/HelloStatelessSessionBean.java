package ejb.stateless;

import javax.ejb.Stateless;

@Stateless(name = "HelloStatelessSessionBean")
public class HelloStatelessSessionBean {

    public HelloStatelessSessionBean() {

    }

    public String hello(){
        return "Hello from STATELESS SESSION BEAN";
    }
}
