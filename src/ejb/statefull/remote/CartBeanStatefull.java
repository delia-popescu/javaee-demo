package ejb.statefull.remote;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartBeanStatefull implements Cart{

    List<String> items;

    public CartBeanStatefull() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void purchase() {
        //. . .
    }

    public List<String> getItems() {
        return items;
    }

    @Remove
    public void remove() {
        items = null;
    }

}
