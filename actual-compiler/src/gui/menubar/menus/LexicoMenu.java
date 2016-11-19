package gui.menubar.menus;

import gui.Frame;

import compilerSintaticLexic.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by lucas on 10/29/16.
 */
public class LexicoMenu extends JMenu {
    private LexicoMenuListener listener;

    public LexicoMenu(Frame frame) {
        this.listener = new LexicoMenuListener(frame);
        this.setText("Léxico");
        this.addMenuListener(listener);
    }
}

class LexicoMenuListener implements MenuListener {
    private Frame frame;
    private Lexico lexico;

    public LexicoMenuListener(Frame frame) {
        this.lexico = new Lexico();
        this.frame = frame;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        String codigo = this.frame.getCodigo();
        lexico.setInput(codigo);

        JOptionPane optionPane = new JOptionPane("Analizando...",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Token currentToken = lexico.nextToken();

                    while (currentToken != null) {
                        currentToken = lexico.nextToken();
                    }

                    // ta certo lexicamente
                    JOptionPane.showMessageDialog(frame, "Seu código esta lexicamente correto.");
                } catch (LexicalError lexicalError) {
                    int pos = lexicalError.getPosition();
                    String msg = "Um erro léxico foi identificado:\n";

                    msg += lexicalError.getMessage() + "\n";
                    msg += "Posição: " + pos;

                    JOptionPane.showMessageDialog(frame, msg);
                    frame.setCursorPosition(pos);

                    // lexicalError.printStackTrace();
                }
            }
        }).start();

        dialog.dispose();
    }

    @Override
    public void menuDeselected(MenuEvent e) {}

    @Override
    public void menuCanceled(MenuEvent e) {}
}
