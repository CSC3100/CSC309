import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

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

                String res = "";
                LinkedList<Box> boxes = Blackboard.getInstance().getBoxes();

                for(Box b : boxes)
                {
                    res += "class " + b.getName() + "{}";
                }

                Lexer lex = new Lexer(res);
                lex.run();
                Vector<Token> tokens = lex.getTokens();

                 LinkedList<Box> newBoxes =  new LinkedList<>();

                int i = 0;
                while( i < tokens.size())
                {
                    if (tokens.get(i).getToken().equals("class"))
                    {
                        Point p = Blackboard.getInstance().getNextPositionAvailable();
                        Box b = new Box(tokens.get(i+1).getToken(), (int)p.getX(), (int)p.getY());
                        i += 2;
                    }
                    else
                    {
                        i++;
                    }
                }
                Blackboard.getInstance().setBoxes(newBoxes);
                break;

            case "About":
                System.out.println("under construction ...5");
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

