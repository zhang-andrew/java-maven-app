package com.andrewzhang.projects.managers;
import com.andrewzhang.projects.ui.GameScreen;
import com.andrewzhang.projects.ui.PauseScreen;
import com.andrewzhang.projects.ui.StartScreen;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private StartScreen startScreen = new StartScreen();
    private GameScreen gameScreen = new GameScreen();
    private PauseScreen pauseScreen = new PauseScreen();


    public GUI(){
        super("Text-Based RPG Game");
        
        // resize this frame to fit its components at their preferred sizes.
        this.pack();
        // set window size
        this.setSize(400, 300);
        // set the default close operation to exit the program
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centers the window on screen
        this.setLocationRelativeTo(null);
        
        
        // A CardLayout is a layout manager in Java that allows you to stack multiple panels on top of each other
        CardLayout contentLayout = new CardLayout();
        // Create the content pane with CardLayout and add the screens
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(contentLayout);

        //add event listener to button
        startScreen.getStartButton().addActionListener(event -> {
            // contentLayout.next(contentPanel);
            contentLayout.show(contentPanel, "game");
        });

        //add screens
        contentPanel.add(startScreen, "start");
        contentPanel.add(gameScreen, "game");
        contentPanel.add(pauseScreen, "pause");

        //add contentPanel to GUI frame
        this.add(contentPanel);
    }

    public void start(){
        // set window to be visible
        this.setVisible(true);
    }
    

    public StartScreen getStartScreen() {
        return startScreen;
    }
    public GameScreen getGameScreen() {
        return gameScreen;
    }
    public PauseScreen getPauseScreen() {
        return pauseScreen;
    }
}
