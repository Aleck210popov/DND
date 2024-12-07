package org.example;

import org.example.ui.FrameMain;

public class App {
    public static void main(String[] args) {
        startGraphicalInterface();
    }

    private static void startGraphicalInterface(){
        FrameMain frame = FrameMain.getSingleton();
        frame.setVisible(true);
    }
}