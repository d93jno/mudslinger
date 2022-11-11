package com.jjnordin.mudslinger.gui;

import uic.themeconfig.FontPreview;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.event.*;
import java.awt.*;

import com.jjnordin.mudslinger.Configuration;

public class WorldProperties extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTree worldOptionsTree;
    private JPanel optionsPanel;
    private JPanel fontsCard;
    private JPanel connectionCard;
    private JPanel loginCard;
    private JPanel colorsCard;
    private FontPreview mainWindowFontPreview;
    private FontPreview inputAreaFontPreview;
    private FontPreview statusBarFontPreview;
    private JTextField hostTextField;
    private JFormattedTextField portTextField;
    private JTextField textField1;
    private JTextField textField2;

    public WorldProperties() {
        $$$setupUI$$$();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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
        worldOptionsTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        worldOptionsTree.getLastSelectedPathComponent();

                //Nothing is selected.
                if (node == null) {
                    return;
                }

                if (node.isLeaf()) {
                    String cardName = (String) node.getUserObject();
                    System.out.println("Switching to " + cardName);
                    CardLayout cl = (CardLayout) (optionsPanel.getLayout());
                    cl.show(optionsPanel, (String) node.getUserObject());
                }
            }
        });
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        contentPane = new JPanel();
        fontsCard = new JPanel();
        mainWindowFontPreview = new FontPreview("Main window", Configuration.getInstance().getMainWindowFont(), Configuration.getInstance().getTheme(), "mudslinger.mainwindow.font");
        mainWindowFontPreview.setPreferredSize(new Dimension(200, 35));
        mainWindowFontPreview.setMinimumSize(new Dimension(200, 35));
        inputAreaFontPreview = new FontPreview("Input area", Configuration.getInstance().getInputAreaFont(), Configuration.getInstance().getTheme(), "mudslinger.inputarea.font");
        inputAreaFontPreview.setPreferredSize(new Dimension(200, 35));
        inputAreaFontPreview.setMinimumSize(new Dimension(200, 35));
        statusBarFontPreview = new FontPreview("Statusbar", Configuration.getInstance().getStatusBarFont(), Configuration.getInstance().getTheme(), "mudslinger.statusbar.font");
        statusBarFontPreview.setPreferredSize(new Dimension(200, 35));
        statusBarFontPreview.setMinimumSize(new Dimension(200, 35));

        createOptionsTree();
    }

    private void createOptionsTree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("World options");

        // -------------------------------------------------------------------
        // General

        DefaultMutableTreeNode general = new DefaultMutableTreeNode("General");

        DefaultMutableTreeNode connection = new DefaultMutableTreeNode("Connection");
        general.add(connection);

        DefaultMutableTreeNode login = new DefaultMutableTreeNode("Login");
        general.add(login);

        top.add(general);

        // -------------------------------------------------------------------
        // Appearence

        DefaultMutableTreeNode appearence = new DefaultMutableTreeNode("Appearence");

        DefaultMutableTreeNode fonts = new DefaultMutableTreeNode("Fonts");
        appearence.add(fonts);

        DefaultMutableTreeNode colors = new DefaultMutableTreeNode("Colors");
        appearence.add(colors);

        top.add(appearence);

        worldOptionsTree = new JTree(top);

        // Remove the icons
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) worldOptionsTree.getCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setClosedIcon(null);
        renderer.setOpenIcon(null);

        // Expand the tree
        for (int i = 0; i < worldOptionsTree.getRowCount(); i++) {
            worldOptionsTree.expandRow(i);
        }
    }


    public static void main(String[] args) {
        WorldProperties dialog = new WorldProperties();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
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
        contentPane.setLayout(new GridBagLayout());
        contentPane.setMinimumSize(new Dimension(150, 45));
        contentPane.setPreferredSize(new Dimension(640, 345));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(panel1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        buttonOK = new JButton();
        buttonOK.setMaximumSize(new Dimension(75, 25));
        buttonOK.setMinimumSize(new Dimension(75, 25));
        buttonOK.setPreferredSize(new Dimension(75, 25));
        buttonOK.setText("OK");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(buttonOK, gbc);
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(buttonCancel, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel3, gbc);
        final JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setDividerLocation(200);
        panel3.add(splitPane1, BorderLayout.CENTER);
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new CardLayout(0, 0));
        splitPane1.setRightComponent(optionsPanel);
        fontsCard.setLayout(new GridBagLayout());
        optionsPanel.add(fontsCard, "Fonts");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        fontsCard.add(mainWindowFontPreview, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        fontsCard.add(inputAreaFontPreview, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        fontsCard.add(statusBarFontPreview, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fontsCard.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fontsCard.add(spacer2, gbc);
        connectionCard = new JPanel();
        connectionCard.setLayout(new GridBagLayout());
        optionsPanel.add(connectionCard, "Connection");
        final JLabel label1 = new JLabel();
        label1.setText("Host");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        connectionCard.add(label1, gbc);
        hostTextField = new JTextField();
        hostTextField.setColumns(30);
        hostTextField.setMinimumSize(new Dimension(180, 21));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        connectionCard.add(hostTextField, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Port");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        connectionCard.add(label2, gbc);
        portTextField = new JFormattedTextField();
        portTextField.setColumns(5);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        connectionCard.add(portTextField, gbc);
        loginCard = new JPanel();
        loginCard.setLayout(new GridBagLayout());
        optionsPanel.add(loginCard, "Login");
        final JLabel label3 = new JLabel();
        label3.setText("Character name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        loginCard.add(label3, gbc);
        textField1 = new JTextField();
        textField1.setColumns(30);
        textField1.setMinimumSize(new Dimension(120, 21));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginCard.add(textField1, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginCard.add(label4, gbc);
        textField2 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginCard.add(textField2, gbc);
        colorsCard = new JPanel();
        colorsCard.setLayout(new BorderLayout(0, 0));
        optionsPanel.add(colorsCard, "Colors");
        final JScrollPane scrollPane1 = new JScrollPane();
        splitPane1.setLeftComponent(scrollPane1);
        worldOptionsTree.setPreferredSize(new Dimension(200, 48));
        worldOptionsTree.setRootVisible(false);
        worldOptionsTree.setScrollsOnExpand(false);
        worldOptionsTree.setShowsRootHandles(true);
        worldOptionsTree.setToggleClickCount(2);
        scrollPane1.setViewportView(worldOptionsTree);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
