package com.jjnordin.mudslinger.gui;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * This represents the menu component of the MUD Connection Frame. Abstracted to a sepearate class for clarity.
 */
public class MudConnectionFrameMenu extends JMenuBar {
    public MudConnectionFrameMenu() {
        createWorldMenu();
    }

    private void createWorldMenu() {
        JMenu menu = new JMenu("Wold");
        menu.setMnemonic(KeyEvent.VK_W);
        menu.getAccessibleContext().setAccessibleDescription(
                "Menu selections regarding the currently selected world.");

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.setMnemonic(KeyEvent.VK_C);
        connectItem.getAccessibleContext().setAccessibleDescription("connect to the current world.");
        menu.add(connectItem);

        JMenuItem reconnectItem = new JMenuItem("Reconnect");
        reconnectItem.setMnemonic(KeyEvent.VK_R);
        reconnectItem.getAccessibleContext().setAccessibleDescription("Reconnect to the current world. Same as doing disconnect and then connect.");
        menu.add(reconnectItem);

        JMenuItem disconnectItem = new JMenuItem("Disconnect");
        disconnectItem.setMnemonic(KeyEvent.VK_D);
        disconnectItem.getAccessibleContext().setAccessibleDescription("Disconnect from the current world");
        menu.add(disconnectItem);

        menu.addSeparator();

        JMenuItem optionsItem = new JMenuItem("World settings");
        optionsItem.setMnemonic(KeyEvent.VK_W);
        optionsItem.getAccessibleContext().setAccessibleDescription("Change the settings for the current world.");
        menu.add(optionsItem);

        JMenu editMenu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);

        JMenuItem copyItem = new JMenuItem("Copy");
        optionsItem.setMnemonic(KeyEvent.VK_C);
        optionsItem.setAccelerator(KeyStroke.getKeyStroke('c', java.awt.event.InputEvent.CTRL_DOWN_MASK));
        optionsItem.getAccessibleContext().setAccessibleDescription("Copy the currently marked text.");
        editMenu.add(copyItem);

        // Add all submenus to the menu bar
        add(menu);
        add(editMenu);

    }
}
