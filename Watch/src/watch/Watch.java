package watch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
	
	private static final double Seconds = (2 * Math.PI)/60;
    private static final double Minutes = Seconds/ 60;
    private static final double Hours = Minutes / 24;

    private double CurrentSeconds =  (Math.PI / 2) + LocalDateTime.now().getSecond() *Seconds;
    private double CurrentMinutes =  (Math.PI / 2) + LocalDateTime.now().getMinute() *Seconds;
    private double CurrentHours =  (Math.PI / 2) + (LocalDateTime.now().getHour() % 12) *(2* Math.PI/12);
    private final Timer timer;
    private final List<Observer> observers = new ArrayList<>();
    
    public Watch() {
        timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObservers();
            }

        };
    }
    
    public double getSeconds() {
        return CurrentSeconds;
    }

    public double getMinutes() {
        return CurrentMinutes;
    }

    public double getHours() {
        return CurrentHours;
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    private void step() {
    	CurrentSeconds = (CurrentSeconds + Seconds) % (2*Math.PI);
        CurrentMinutes = (CurrentMinutes + Minutes)% (2*Math.PI);
        CurrentHours = (CurrentHours + Hours)% (2*Math.PI);
    }
    
    private void updateObservers() {
    	for (Observer observer : observers) 
    		observer.update(null, null);
    }
    
    
}
