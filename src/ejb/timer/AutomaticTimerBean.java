package ejb.timer;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import java.time.LocalDateTime;

@Startup
@Singleton
public class AutomaticTimerBean {

//    @Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
    public void printDate() {
        System.out.println("AutomaticTimerBean: " + LocalDateTime.now());
    }

//    @Schedule(hour = "*", minute = "*", second = "*/10", info = "Every 10 second timer")
    public void printDate2(Timer timer) {
        System.out.println("AutomaticTimerBean: " + timer.getInfo() + " " + LocalDateTime.now());
    }
}
