package agh.ics.oop;
import javax.swing.*;
import java.awt.*;


public class MapVisualizerWidget extends JFrame {
    public MapVisualizerWidget() {
        super("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(300, 300);
        JTextArea area = new JTextArea(30, 30);
        area.setEditable(false);
        area.setFont(new Font(Font.DIALOG, Font.PLAIN, 19));
        add(area, BorderLayout.CENTER);
        setVisible(true);
    }

}
