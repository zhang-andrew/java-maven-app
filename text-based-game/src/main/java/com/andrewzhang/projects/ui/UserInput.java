package com.andrewzhang.projects.ui;
import java.util.ArrayList;
import java.util.List;
// import java.util.Map;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import com.andrewzhang.projects.gameObject.GameObject;
import com.andrewzhang.projects.gameObject.Room;
import com.andrewzhang.projects.managers.GameManager;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class UserInput {
    // Map<String, >
    private List<String> verbs;
    
    private JTextField inputField;
    private JPanel containerPanel;
    private OutputDisplay outputDisplay;

    // public GameManager gameManager = GameManager.getInstance();
    private Room currentRoom;
    
    public UserInput(OutputDisplay _outputDisplay){
        verbs = new ArrayList<String>();
        verbs.add("Inspect");
        verbs.add("Observe");

        
        // {{
        //     add("asdf");
        // }};

        //set the _outputDisplay parameter to be the class field outputDisplay's value
        outputDisplay = _outputDisplay;


        // create the input fields, and add to frame
        inputField = new JTextField();
        inputField.addActionListener(e -> handleInput());
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel promptLabel = new JLabel(" >");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        containerPanel = new JPanel(new BorderLayout()); 
        containerPanel.add(promptLabel, BorderLayout.WEST);
        containerPanel.add(inputField, BorderLayout.CENTER);
    }

    private void handleInput(){
        String input = inputField.getText();
        String[] words = input.split("\\s+");
        String verb = words[0];
        String nounName = words.length > 1 ? words[1] : "";
        int objectIndex = isInteger(nounName) ? Integer.parseInt(nounName) : 0; 

        // reset inputField
        inputField.setText("");

        // handle user's input
        switch (verb.toLowerCase()) {
            case "inspect":
            case "observe":
                if (nounName.isEmpty()){
                    //then inspect room
                    currentRoom = GameManager.getInstance().getCurrentRoom();
                    outputDisplay.writeLine(String.format("You inspect your surroundings. (\"%s\")", currentRoom.getName()));
                    outputDisplay.writeOutput(currentRoom.inspect());
                } else if (objectIndex != 0) {                    
                    //get object at index (negative -1 though because the list starts at 0)
                    currentRoom = GameManager.getInstance().getCurrentRoom();                
                    GameObject object = currentRoom.getObjects().get(objectIndex - 1);
                    outputDisplay.writeLine(String.format("You inspect an object. (\"%s\")", object.getName()));
                    outputDisplay.writeLine(String.format("%s", object.getDescription()));
                } else {
                    //write to display attempt
                    outputDisplay.writeLine(String.format("You attempted to inspect: \"%s\"", nounName));
                }
                // if (noun is an object in room
                // getObject id
                // if (gameMananger.currentRoom.contains(noun)){
                    // GameObject target = gameManager.currentRoom.getObject()
                    // outputDisplay.writeOutput(noun);
                // }
                
                break;
            case "attack":
            case "hit":
                //Check equipment of player

                //
                outputDisplay.writeLine(String.format("You attempted to inspect: \"%s\"", nounName));
                break;
            default:
                outputDisplay.writeLine(input);
                break;
        }
        System.out.println(verbs.contains("Inspect"));
    }



    public JPanel getContainerPanel(){
        return containerPanel;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
