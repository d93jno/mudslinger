package com.jjnordin.mudslinger.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class WorldSelector extends JFrame {
    private JPanel contentPane;
    private JButton buttonConnect;
    private JButton buttonExit;
    private JPanel itemPanel;
    private JList worldList;
    private JPanel toolbarPanel;
    private JButton addButton;
    private JButton removeButton;
    private WorldSelectorMenu worldSelectorMenu = new WorldSelectorMenu();
    private final Object exitMonitor = new Object();

    public WorldSelector() {
        $$$setupUI$$$();
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonConnect);

        buttonConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWorld();
            }
        });
    }

    /**
     * Blocks until the "Exit" menu entry is choosen.
     */
    public void waitOnExit() {
        synchronized (exitMonitor) {
            boolean done = false;
            while (!done) {
                try {
                    exitMonitor.wait();
                    done = true;
                } catch (InterruptedException e) {
                    // No action
                }
            }
        }
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
        synchronized (exitMonitor) {
            exitMonitor.notify();
        }
        dispose();

    }

    public static void main(String[] args) {
        WorldSelector dialog = new WorldSelector();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        addButton = new JButton();
        removeButton = new JButton();

        setJMenuBar(worldSelectorMenu);
    }

    // -----------------------------------------------------------------------
    // Action methods

    private void addWorld() {
        WorldProperties worldProperties = new WorldProperties();
        worldProperties.pack();
        worldProperties.setVisible(true);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel1, BorderLayout.NORTH);
        final JLabel label1 = new JLabel();
        label1.setText("  Select the world you want to connect to");
        panel1.add(label1, BorderLayout.NORTH);
        toolbarPanel = new JPanel();
        toolbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel1.add(toolbarPanel, BorderLayout.CENTER);
        addButton.setMargin(new Insets(0, 0, 0, 0));
        addButton.setMaximumSize(new Dimension(34, 20));
        addButton.setMinimumSize(new Dimension(43, 25));
        addButton.setPreferredSize(new Dimension(20, 23));
        addButton.setText("+");
        addButton.setToolTipText("Add a new world.");
        toolbarPanel.add(addButton);
        removeButton.setEnabled(false);
        removeButton.setMargin(new Insets(0, 0, 0, 0));
        removeButton.setMaximumSize(new Dimension(42, 25));
        removeButton.setMinimumSize(new Dimension(42, 25));
        removeButton.setPreferredSize(new Dimension(20, 23));
        removeButton.setText("-");
        removeButton.setToolTipText("Remove selected world from the list.");
        toolbarPanel.add(removeButton);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        contentPane.add(panel2, BorderLayout.SOUTH);
        buttonConnect = new JButton();
        buttonConnect.setEnabled(false);
        buttonConnect.setPreferredSize(new Dimension(100, 25));
        buttonConnect.setText("Connect");
        buttonConnect.setMnemonic('C');
        buttonConnect.setDisplayedMnemonicIndex(0);
        panel2.add(buttonConnect);
        buttonExit = new JButton();
        buttonExit.setPreferredSize(new Dimension(100, 25));
        buttonExit.setText("Exit");
        buttonExit.setMnemonic('E');
        buttonExit.setDisplayedMnemonicIndex(0);
        panel2.add(buttonExit);
        itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout(0, 0));
        contentPane.add(itemPanel, BorderLayout.CENTER);
        final JScrollPane scrollPane1 = new JScrollPane();
        itemPanel.add(scrollPane1, BorderLayout.CENTER);
        worldList = new JList();
        scrollPane1.setViewportView(worldList);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
