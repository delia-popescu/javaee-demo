package ejb.statefull;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartBean {

    List<String> items;

    public CartBean() {
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
