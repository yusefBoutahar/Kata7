package watch;

import java.io.IOException;
import javax.swing.JFrame;


public class Main extends JFrame{
    

    public Main() throws IOException {
    	
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        new WatchPresenter(watch, watchDisplay);
        this.setTitle("Is2-Kata7-Watch");
        this.setBounds(100,100,516,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(watchDisplay);
    }
    
    

    private void run() {
        this.setVisible(true);
    }
    
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    
}
