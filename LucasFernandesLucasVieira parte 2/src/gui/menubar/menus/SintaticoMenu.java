package gui.menubar.menus;

import compilerSintaticLexic.*;
import gui.Frame;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by lucas on 10/29/16.
 */
public class SintaticoMenu extends JMenu {
    private SintaticoMenuListener listener;

    public SintaticoMenu(Frame frame) {
        this.listener = new SintaticoMenuListener(frame);
        this.setText("Sintático");
        this.addMenuListener(listener);
    }

    private class SintaticoMenuListener implements MenuListener {
        private Frame frame;
        private Sintatico sintatico;

        public SintaticoMenuListener(Frame frame) {
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
                        lexicalError.printStackTrace();
                        showSuccess();
                    } catch (SemanticError semanticError) {
                        semanticError.printStackTrace();
                        showSuccess();
                    }
                }

                private void showSuccess() {
                    dialog.dispose();
                    JOptionPane.showMessageDialog(frame, "Seu código esta sintaticamente correto.");
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
