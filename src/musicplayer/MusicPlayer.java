package musicplayer;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;

/**
 *
 * @author tejas
 */
public class MusicPlayer {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }        
        Homepage homepage = new Homepage();
        Splashscreen splashscreen = new Splashscreen();
        splashscreen.setVisible(true);
        homepage.setVisible(false);
        
        // Loop for the ProgressBar splashscreen
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(10);
                Splashscreen.loading.setValue(i);
                if (i==100) {
                    splashscreen.setVisible(false);
                    homepage.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
        homepage.cardLayout.show(homepage.cardPanel, "card2");
    }
    
}
