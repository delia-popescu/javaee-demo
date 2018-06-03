package ejb.async;

import javax.ejb.AsyncResult;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
public class MyMethodLevelAsync {

    public Future<Integer> add(int n1, int n2){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(n1 + n2);
    }
}
