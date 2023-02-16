import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFrame extends JFrame {
    
    private void assembleMenu() {
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        menu.add(fileMenu);
        JMenu buildMenu = new JMenu("Build");
        JMenuItem buildMenuItem = new JMenuItem("Build Project");
        buildMenu.add(buildMenuItem);
        menu.add(buildMenu);
        JMenu help = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        help.add(aboutMenuItem);
        menu.add(help);
        MainFrameController actionListener = new MainFrameController();
        newMenuItem.addActionListener(actionListener);
        saveMenuItem.addActionListener(actionListener);
        loadMenuItem.addActionListener(actionListener);
        buildMenuItem.addActionListener(actionListener);
        aboutMenuItem.addActionListener(actionListener);
    }

    public void assembleToolBar(){
        JToolBar bar = new JToolBar();

        JButton[] types = {new JButton("Class"), new JButton("Interface"), new JButton("Abstract")};
        JButton[] connectionTypes = {new JButton("Inheritance"), new JButton("Association"),
                new JButton("Composition")};
        MainFrameController toolBarController = new MainFrameController();
        for (JButton j : types){
            j.addActionListener(toolBarController);
            bar.add(j);
        }
        for (JButton j : connectionTypes){
            j.addActionListener(toolBarController);
            bar.add(j);
        }

        bar.setVisible(true);
        this.add(bar, BorderLayout.NORTH);
    }
    
    public MainFrame(){
        super("CSC308 - Final Project");
        assembleMenu();
        setLayout(new BorderLayout());
        assembleToolBar();
        StatusBarPanel status = new StatusBarPanel();
        DrawPanel canvas = new DrawPanel();
        TextPanel textBox = new TextPanel();
        add(canvas, BorderLayout.CENTER);
        add(textBox, BorderLayout.WEST);
        textBox.setPreferredSize(new Dimension(200,200));
        add(status, BorderLayout.SOUTH);
        Blackboard.getInstance().addObserver(canvas);
        Blackboard.getInstance().addObserver(textBox);
        Blackboard.getInstance().addObserver(status);
    }
    
    public static void main(String[] args){
        MainFrame main = new MainFrame();
        main.setSize(900, 700);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setVisible(true);
    }
}