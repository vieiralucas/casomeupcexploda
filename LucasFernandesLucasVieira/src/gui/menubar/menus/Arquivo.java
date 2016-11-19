package gui.menubar.menus;

import gui.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Created by lucas on 10/29/16.
 */
public class Arquivo extends JMenu {
    private Abrir abrir;
    private Salvar salvar;

    public Arquivo(Frame frame) {
        this.setText("Arquivo");

        abrir = new Abrir(frame);
        this.add(abrir);

        salvar = new Salvar(frame);
        this.add(salvar);
    }
}

class Abrir extends JMenuItem {
    private AbrirMenuListener listener;

    public Abrir(Frame frame) {
        this.setText("Abrir");
        this.listener = new AbrirMenuListener(frame);
        this.addActionListener(listener);
    }

    private class AbrirMenuListener extends AbstractAction {
        private Frame frame;
        private JFileChooser fileChooser;

        public AbrirMenuListener(Frame frame) {
            this.frame = frame;
            this.fileChooser = new JFileChooser();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal = this.fileChooser.showOpenDialog(this.frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = this.fileChooser.getSelectedFile();
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException e1) {
                    showFileOpenErrorMessage();
                    return;
                }

                byte[] data = new byte[(int) file.length()];
                try {
                    fis.read(data);
                    fis.close();
                } catch (IOException e1) {
                    showFileOpenErrorMessage();
                    return;
                }

                try {
                    String str = new String(data, "UTF-8");
                    this.frame.setText(str);
                } catch (UnsupportedEncodingException e1) {
                    showFileOpenErrorMessage();
                    return;
                }
            }
        }

        private void showFileOpenErrorMessage() {
            JOptionPane.showMessageDialog(this.frame, "Não foi possível ler o arquivo selecionado.");
        }
    }
}

class Salvar extends JMenuItem {
    private SalvarMenuListener listener;

    public Salvar(Frame frame) {
        this.setText("Salvar");
        this.listener = new SalvarMenuListener(frame);
        this.addActionListener(listener);
    }

    private class SalvarMenuListener extends AbstractAction {
        private Frame frame;
        private JFileChooser fileChooser;

        public SalvarMenuListener(Frame frame) {
            this.frame = frame;
            this.fileChooser = new JFileChooser();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal = this.fileChooser.showSaveDialog(this.frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = this.fileChooser.getSelectedFile();

                if (!file.isFile()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        showFileOpenErrorMessage();
                        return;
                    }
                }

                FileWriter fw = null;
                try {
                    fw = new FileWriter(file);
                } catch (IOException e1) {
                    showFileOpenErrorMessage();
                    return;
                }

                try {
                    fw.write(this.frame.getCodigo());
                    fw.close();
                } catch (IOException e1) {
                    showFileOpenErrorMessage();
                }
            }
        }

        private void showFileOpenErrorMessage() {
            JOptionPane.showMessageDialog(this.frame, "Não foi possível ler o arquivo selecionado.");
        }
    }
}
