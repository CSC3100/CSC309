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
                Blackboard.getInstance().buildProjectStatusBarUpdate();
                System.out.println("under construction ...4");
                break;
            case "Class":
                System.out.println("Class Button");
                break;
            case "Interface":
                System.out.println("Interface Button");
                break;
            case "Abstract":
                System.out.println("Abstract Button");
                break;
            case "Inheritance":
                System.out.println("Inheritance Button");
                break;
            case "Association":
                System.out.println("Association Button");
                break;
            case "Composition":
                System.out.println("Composition Button");
                break;
        }
    }
}

