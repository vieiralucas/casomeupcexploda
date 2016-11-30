package gui.menubar.menus;

import compilerSemantic.*;
import gui.Frame;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by lucas on 10/29/16.
 */
public class SemanticoMenu extends JMenu {
    private SemanticoMenuListener listener;

    public SemanticoMenu(Frame frame) {
        this.listener = new SemanticoMenuListener(frame);
        this.setText("Sintático");
        this.addMenuListener(listener);
    }

    private class SemanticoMenuListener implements MenuListener {
        private Frame frame;
        private Sintatico sintatico;

        public SemanticoMenuListener(Frame frame) {
            this.frame = frame;
            this.sintatico = new Sintatico();
        }

        @Override
        public void menuSelected(MenuEvent e) {
            String codigo = frame.getCodigo();
            final Lexico scanner = new Lexico();
            scanner.setInput(codigo);

            final Semantico semanticAnalyzer = new Semantico();

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
                        sintatico.parse(scanner, semanticAnalyzer);
                        showSuccess();
                    } catch (SyntaticError syntaticError) {
                        dialog.dispose();

                        int pos = syntaticError.getPosition();
                        String msg = "Um erro sintático foi identificado:\n";

                        msg += syntaticError.getMessage() + "\n";
                        msg += "Posição: " + pos;

                        JOptionPane.showMessageDialog(frame, msg);
                        frame.setCursorPosition(pos);

                        syntaticError.printStackTrace();
                    } catch (LexicalError lexicalError) {
                        int pos = lexicalError.getPosition();
                        String msg = "Um erro léxico foi identificado:\n";

                        msg += lexicalError.getMessage() + "\n";
                        msg += "Posição: " + pos;

                        JOptionPane.showMessageDialog(frame, msg);
                        frame.setCursorPosition(pos);

                        lexicalError.printStackTrace();
                    } catch (SemanticError semanticError) {
                        dialog.dispose();

                        JOptionPane.showMessageDialog(frame, semanticError.getMessage());
                        frame.setCursorPosition(semanticError.getPosition());

                        semanticError.printStackTrace();
                    }
                }

                private void showSuccess() {
                    dialog.dispose();
                    JOptionPane.showMessageDialog(frame, "Seu código esta semanticamente correto.");
                }
            }).start();

            dialog.setVisible(true);
        }

        @Override
        public void menuDeselected(MenuEvent e) {}

        @Override
        public void menuCanceled(MenuEvent e) {}
    }
}
