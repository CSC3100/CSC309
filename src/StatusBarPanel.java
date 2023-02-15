import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class StatusBarPanel extends JPanel implements Observer {

    private JLabel statusLabel;

    public StatusBarPanel(){
        statusLabel = new JLabel("   Status: OK");
        setLayout(new GridLayout(1, 1));
        add(statusLabel);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        statusLabel.setText("   " + Blackboard.getInstance().getStatusBarMessage());
        statusLabel.revalidate();
    }
}
