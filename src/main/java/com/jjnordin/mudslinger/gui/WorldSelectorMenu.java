package com.jjnordin.mudslinger.gui;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Menubar for the world selector frame. Extracted into a separate class for clarity.
 */
public class WorldSelectorMenu extends JMenuBar {
    public WorldSelectorMenu() {
        createWorldSelectorMenu();
    }

    private void createWorldSelectorMenu() {
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        menu.addSeparator();
        JMenuItem connectItem = new JMenuItem("Exit");
        connectItem.setMnemonic(KeyEvent.VK_X);
        connectItem.getAccessibleContext().setAccessibleDescription("Close all connections and exit the applicatio.");
        menu.add(connectItem);

        add(menu);
    }
}
