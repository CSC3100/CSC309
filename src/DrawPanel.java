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
            if(c.isSelected()){
                int index = Blackboard.getInstance().getBoxes().indexOf(c);
                Box temp = c;
                Blackboard.getInstance().getBoxes().remove(index);
                Blackboard.getInstance().getBoxes().addLast(temp);
                break;
            }
        }
        for(Box c : Blackboard.getInstance().getBoxes()){
                c.draw(g);
        }

    }
    
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
