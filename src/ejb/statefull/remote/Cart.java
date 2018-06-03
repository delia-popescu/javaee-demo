package ejb.statefull.remote;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Cart {

    void addItem(String item);

    void removeItem(String item);

    List<String> getItems();

    void purchase();

    void remove();
}
