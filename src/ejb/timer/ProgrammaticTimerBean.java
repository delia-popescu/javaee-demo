package ejb.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.time.LocalDateTime;

@Startup
@Singleton
public class ProgrammaticTimerBean {

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void initialize() {
        ScheduleExpression scheduleExpression = new ScheduleExpression()
                .hour("*")
                .minute("*")
                .hour("*/5");

        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("Every 5 seconds timer");

        timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }

    @Timeout
    public void programmaticTimout(Timer timer) {
        System.out.println("ProgramaticTimerBean: " + timer.getInfo() + " " + LocalDateTime.now());

        timerService.getAllTimers().forEach(timer1 -> System.out.println(timer1.getInfo()));
    }
}
