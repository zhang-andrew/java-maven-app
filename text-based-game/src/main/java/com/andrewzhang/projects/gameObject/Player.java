package com.andrewzhang.projects.gameObject;
import java.util.List;

import com.andrewzhang.projects.domain.Output;

public class Player extends GameObject{
    private int health;
    private List<Item> inventory;
    // private String[] inventory;

    public Player(String name, String description){
        super(name, description);
        // this.inventory = new ArrayList<>();

    }

    public Output look(){
        Output output = new Output();
        output.setSuccess(true);
        output.setMessage("You look around.");
        return output;
    }

    public Output inspect(){
        Output output = new Output();
        output.setSuccess(true);
        output.setMessage(this.getDescription());
        return output;
    }

    
    
}
