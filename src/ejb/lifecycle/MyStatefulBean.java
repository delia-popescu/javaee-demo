package ejb.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class MyStatefulBean {

    List<String> items;

    public MyStatefulBean(){
        items = new ArrayList<>();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("MyStatefulBean.postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("MyStatefulBean.preDestroy");
    }

    @PrePassivate
    public void prePassivate(){
        System.out.println("MyStatefulBean.prePassivate");
    }

    @PostActivate
    public void postActivate(){
        System.out.println("MyStatefulBean.postActivate");
    }

    public void addItem(String item){
        items.add(item);
    }

    public void removeItem(String item){
        items.remove(item);
    }

    public List<String> getItems(){
        return items;
    }
}
