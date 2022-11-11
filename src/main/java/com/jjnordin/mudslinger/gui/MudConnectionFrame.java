package com.jjnordin.mudslinger.gui;

import de.mud.terminal.SwingTerminal;
import de.mud.terminal.vt320;

import javax.swing.*;
import java.awt.*;

/**
 * One window abstraction that represents one MUD connection
 */
public class MudConnectionFrame extends JFrame {
    private JPanel contentPane = new JPanel();

    public MudConnectionFrame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setJMenuBar(new MudConnectionFrameMenu());

        setContentPane(contentPane);

        setupGui();
    }

    private void setupGui() {
        contentPane.setLayout(new BorderLayout(0, 0));

        // contentPane.add(terminal, BorderLayout.CENTER);

    }
}
