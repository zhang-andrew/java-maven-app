package com.andrewzhang.projects.ui;

import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

public class PauseScreen extends Screen {
    private JButton continueButton;
    private JButton exitButton;
    
    public PauseScreen(){
        // Add a button to switch to the game screen
        continueButton = new JButton("Continue");
        exitButton = new JButton("Exit to Menu");

        // startButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         cardLayout.show(contentPane, "game");
        //     }
        // });

        //add event listener to continue button
        continueButton.addActionListener(event -> {
            CardLayout cardLayout = (CardLayout) PauseScreen.this.getParent().getLayout();
            JPanel parentPanel = (JPanel) PauseScreen.this.getParent();
            // cardLayout.show(parentPanel, "game");
            cardLayout.previous(parentPanel);
        });

        //add event listener to exit button
        exitButton.addActionListener(event -> {
            CardLayout cardLayout = (CardLayout) PauseScreen.this.getParent().getLayout();
            JPanel parentPanel = (JPanel) PauseScreen.this.getParent();
            cardLayout.show(parentPanel, "start");
        });

        this.add(continueButton);
        this.add(exitButton);
    }
}
