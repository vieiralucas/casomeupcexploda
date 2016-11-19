package gui.menubar;

import gui.Frame;
import gui.menubar.menus.Arquivo;
import gui.menubar.menus.LexicoMenu;
import gui.menubar.menus.SemanticoMenu;
import gui.menubar.menus.SintaticoMenu;

import javax.swing.*;

/**
 * Created by lucas on 10/29/16.
 */
public class MenuBar extends JMenuBar {
    private Arquivo arquivo;
    private LexicoMenu lexicoMenu;
    private SintaticoMenu sintatico;
    private JMenu semantico;
    private JMenu codigo;
    private JMenu ajuda;

    public MenuBar(Frame frame) {
        arquivo = new Arquivo(frame);
        this.add(arquivo);

        lexicoMenu = new LexicoMenu(frame);
        this.add(lexicoMenu);

        sintatico = new SintaticoMenu(frame);
        this.add(sintatico);

        semantico = new SemanticoMenu(frame);
        semantico.setText("Semântico");
        this.add(semantico);

        codigo = new JMenu();
        codigo.setText("Código");
        this.add(codigo);

        ajuda = new JMenu();
        ajuda.setText("Ajuda");
        this.add(ajuda);
    }
}

