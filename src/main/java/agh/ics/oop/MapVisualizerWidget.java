package agh.ics.oop;
import javax.swing.*;
import java.awt.*;


public class MapVisualizerWidget extends JFrame {
    public MapVisualizerWidget() {
        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 700);
        JTextArea area = new JTextArea(400, 600);
        area.setEditable(false);
        area.setFont(new Font("ROMAN_BASELINE", Font.BOLD, 22));
        add(area, BorderLayout.CENTER);
        setVisible(true);
    }

}
