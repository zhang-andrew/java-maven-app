package com.andrewzhang.projects.managers;
import java.util.HashMap;
import java.util.Map;

import com.andrewzhang.projects.gameObject.NPC;
import com.andrewzhang.projects.gameObject.Room;

public class World {
    // private Map<String, GameObject> objects;
    // private Room startingRoom;

    private Map<String, Room> rooms;



    public World(){
        // objects = new HashMap<>();
        rooms = new HashMap<>();


        Room startRoom = new Room("Start Room", "You are in a small room with a door to the east.");
        rooms.put(startRoom.getName(), startRoom);
        NPC tree = new NPC("Ordinary Tree", "Looks like a tree.");
        startRoom.addObject(tree);
        NPC corpse = new NPC("Corpse", "A corpse.");
        startRoom.addObject(corpse);

        Room eastRoom = new Room("East Room", "You are in a larger room with a window to the west.");
        rooms.put(eastRoom.getName(), startRoom);
        
        //attach exits
        startRoom.setExit("east", eastRoom);
        eastRoom.setExit("west", startRoom);


        
    
        //set starting room
        // startingRoom = rooms.get("Start Room");
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }



}
