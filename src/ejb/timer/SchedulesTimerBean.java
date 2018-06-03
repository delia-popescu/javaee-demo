package ejb.timer;

import javax.ejb.*;
import java.time.LocalDateTime;

@Startup
@Singleton
public class SchedulesTimerBean {

//    @Schedules({@Schedule(hour = "*", minute="*", second = "*/10", info="Every 10 seconds"), @Schedule(hour="*", minute = "*", second = "*/5", info = "Every 5 second")})
    public void printDate(Timer timer){
        System.out.println("SchedulesTimerBean: " + timer.getInfo() + " " + LocalDateTime.now());
    }
}