package com.andrewzhang.projects.ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.CardLayout;

public class GameScreen extends Screen{
    private OutputDisplay outputDisplay = new OutputDisplay();
    private UserInput userInput = new UserInput(outputDisplay);
    
    public GameScreen(){
        super();

        //edit this panel
        this.setFocusable(true); // needed for key events
        this.requestFocusInWindow(); // make sure the panel has focus
        
        //add UI components
        // set the frame to use the awt layout manager 
        this.setLayout(new BorderLayout());
        // create the input fields, and add to frame
        this.add(userInput.getContainerPanel(), BorderLayout.SOUTH);
        // create the output text area, and add to frame
        this.add(outputDisplay.getContainerPanel(), BorderLayout.CENTER);


        // Create a new Action for the escape key binding
        Action openMenu = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // this.getLayout();
                System.out.println("Escape key pressed!");
                CardLayout cardLayout = (CardLayout) GameScreen.this.getParent().getLayout();
                JPanel parentPanel = (JPanel) GameScreen.this.getParent();
                cardLayout.show(parentPanel, "pause");
                // contentLayout.show(contentPanel, "game");
            }
        };
        // Add the key binding for the "Escape" key
        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escKey, "openMenu");
        getActionMap().put("openMenu", openMenu);


        // Create action for the Enter keypress
        Action myAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter key pressed!");
            }
        };
        // Add the key binding for the "Enter" key
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "myAction");
        getActionMap().put("myAction", myAction);
    }

    public OutputDisplay getOutputDisplay() {
        return outputDisplay;
    }
    public UserInput getUserInput() {
        return userInput;
    }

}
