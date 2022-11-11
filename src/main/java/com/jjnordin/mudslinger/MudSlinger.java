package com.jjnordin.mudslinger;

import com.jjnordin.mudslinger.gui.WorldSelector;

import javax.swing.*;

public class MudSlinger {

    public static void main(String[] args) {
        // Set our theme to make it look better.
        try {
            //The following line is needed when starting the application from WebStart (only on Windows)
            javax.swing.plaf.metal.MetalLookAndFeel.setCurrentTheme(Configuration.getInstance().getTheme());
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch(Exception e) {
            e.printStackTrace();
        }

        final WorldSelector worldSelector = new WorldSelector();

        try {
            Runnable r = new Runnable() {
                public void run() {
                    // update LaF for the toplevel frame, too
                    javax.swing.SwingUtilities.updateComponentTreeUI(worldSelector);
                }
            };
            javax.swing.SwingUtilities.invokeLater(r);
        } catch (Exception e) {
            e.printStackTrace();
        } // end setting theme.

        worldSelector.pack();
        worldSelector.setVisible(true);        

        worldSelector.waitOnExit();
    }
} 
