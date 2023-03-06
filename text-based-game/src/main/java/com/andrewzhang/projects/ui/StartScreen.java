package com.andrewzhang.projects.ui;

// import javax.swing.ActionEvent;
import javax.swing.JButton;

public class StartScreen extends Screen{
    private JButton startButton;
 


    public StartScreen(){
        // Add a button to switch to the game screen
        startButton = new JButton("Start Game");

        // startButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         cardLayout.show(contentPane, "game");
        //     }
        // });
        this.add(startButton);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }
}
