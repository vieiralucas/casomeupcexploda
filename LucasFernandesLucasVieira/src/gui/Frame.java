package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lucas on 10/29/16.
 */
public class Frame extends JFrame {
    private JTextArea textArea;
    private gui.menubar.MenuBar menuBar;

    public Frame() {
        this.setTitle("Lucas Vieira & Lucas Fernandes Compiler");
        this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new gui.menubar.MenuBar(this);
        this.setJMenuBar(menuBar);

        textArea = new JTextArea("", 100, 100);
        this.add(textArea);
    }

    public String getCodigo() {
        return this.textArea.getText();
    }

    public void setCursorPosition(int pos) {
        this.textArea.requestFocus();

        this.textArea.setCaretPosition(pos);
        this.textArea.select(pos, 10);
    }

    public void setText(String str) {
        this.textArea.setText(str);
    }
}
