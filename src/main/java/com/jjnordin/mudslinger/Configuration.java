package com.jjnordin.mudslinger;

import uic.themes.UICTheme;

import java.awt.*;

/**
 * Collection class for all configuration parameters.
 */
public class Configuration {

    private static Configuration instance = new Configuration();

    private UICTheme theme = new UICTheme();
    private Font mainWindowFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    private Font inputAreaFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    private Font statusBarFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

    public static Configuration getInstance() {
        return instance;
    }

    public UICTheme getTheme() {
        return theme;
    }

    public Font getMainWindowFont() {
        return mainWindowFont;
    }

    public Font getInputAreaFont() {
        return inputAreaFont;
    }

    public Font getStatusBarFont() {
        return statusBarFont;
    }
}
