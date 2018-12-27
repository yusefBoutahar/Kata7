package watch;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer {
	
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    
    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watchDisplay = watchDisplay;
        this.watchDisplay.paint(pointsOf(watch));
        this.watch.add(this);
    }

    @Override
    public void update(Observable o, Object obj) {
        refreshDisplay();
    }

    private void refreshDisplay() {
        watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointsAngle(watch.getSeconds(), 175);
        points[1] = pointsAngle(watch.getMinutes(), 150);
        points[2] = pointsAngle(watch.getHours(), 80);
        return points;
    }

    private Point pointsAngle(double angle, int size){
        return new Point((int)(Math.cos(angle)*size), (int)(Math.sin(angle)*size));
    }
    
    
    
}
