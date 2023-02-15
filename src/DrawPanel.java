import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DrawPanel extends JPanel implements Observer {
    
    public DrawPanel() {
        DrawPanelController controller = new DrawPanelController(this);
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        for(Box c : Blackboard.getInstance().getBoxes()){
            c.draw(g);
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
