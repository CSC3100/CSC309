// libraries for custom icon
// package com.devdaily.jdialogicon;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

// Annes Huynh, John A

public class MainFrameController implements ActionListener {
    private JFrame MainFrame;

    //private static final String IMG_PATH = "src/logo.ico";

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
            case "About":
                System.out.println("About Button Clicked");
                // Icon img = new ImageIcon(getClass().getResource("\\src\\logo.jpg"));
                ImageIcon img = createImageIcon("src\\logo.jpg", "cal poly logo");
                JOptionPane.showMessageDialog(MainFrame, "CSC 309 - Software Engineering II", "About", JOptionPane.NO_OPTION, img);
                break;
        }
    }

    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

