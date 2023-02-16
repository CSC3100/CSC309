import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Observable;
import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class TextPanel extends JPanel implements Observer, DocumentListener{

    private JTextArea textArea;
    
    public TextPanel(){
        
        textArea = new JTextArea("Source code will appear here: ");
        JScrollPane panel = new JScrollPane (textArea);
        panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setLayout(new GridLayout(1, 1));
        add(panel);
        textArea.getDocument().addDocumentListener(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        String line = "";
        for (Box c : Blackboard.getInstance().getBoxes()) {
            line = line + "class " + c.getName() + " {\n}" + "\n";
        }
        textArea.setText(line);
        textArea.revalidate();
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {}
    
    @Override
    public void removeUpdate(DocumentEvent e) {}
    
    @Override
    public void changedUpdate(DocumentEvent e) {}
    
 
    
}
