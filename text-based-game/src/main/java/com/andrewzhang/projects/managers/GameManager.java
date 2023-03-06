package com.andrewzhang.projects.managers;

import com.andrewzhang.projects.gameObject.Player;
import com.andrewzhang.projects.gameObject.Room;
import com.andrewzhang.projects.ui.OutputDisplay;
import com.andrewzhang.projects.ui.UserInput;

public class GameManager {
    private static GameManager instance;
    private World world = new World();
    private Player user;    
    private Room currentRoom = world.getRooms().get("Start Room");



    private GUI gui = new GUI();
    private UserInput userInput = gui.getGameScreen().getUserInput();
    private OutputDisplay outputDisplay = gui.getGameScreen().getOutputDisplay();

    // constructor method
    private GameManager(){
        System.out.println(userInput);
        System.out.println(outputDisplay);

        outputDisplay.writeOutput(currentRoom.inspect()); 
    }

    // (singleton exception handling): static block initialization for exception handling
    static {
        try {
            instance = new GameManager();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
    public static GameManager getInstance() {
        return instance;
    }

    // launch method
    public void launch(){
        gui.start();
    };


    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
