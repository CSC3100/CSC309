import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "New":
                System.out.println("under construction ...1");
                break;
            case "Save":
                System.out.println("under construction ...2");
                break;
            case "Load":
                System.out.println("under construction ...3");
                break;
            case "Build Project":
                System.out.println("under construction ...4");
                break;
            case "About":
                System.out.println("under construction ...5");
                break;
        }
    }
}

