package ejb.stateless.remote;

import javax.ejb.Remote;

@Remote
public interface Hello {

    String hello();
}
