package ejb.stateless.remote;

import javax.ejb.Stateless;

@Stateless(name = "HelloRemoteStatelessSessionBean")
public class HelloRemoteStatelessSessionBean implements Hello {

    public HelloRemoteStatelessSessionBean() {

    }

    public String hello(){
        return "Hello from REMOTE STATELESS SESSION BEAN";
    }
}
