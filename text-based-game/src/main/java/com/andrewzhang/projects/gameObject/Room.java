package com.andrewzhang.projects.gameObject;

import java.util.List;
import java.util.Map;

import com.andrewzhang.projects.domain.Output;

import java.util.ArrayList;
import java.util.HashMap;



public class Room extends GameObject{
    private Map<String, Room> exits;
    // private Map<String, GameObject> objects;
    private List<GameObject> objects;
    private List<Item> items;

    public Room(String name, String description) {
        super(name, description);
        // this.name = name;
        // this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.objects = new ArrayList<>();
        // this.objects = new HashMap<>();
    }


    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }


    //
    public void addObject(GameObject object) {
        // objects.put(objectId, object);
        objects.add(object);
    }
    public void removeObject(GameObject gameObject) {
        objects.remove(gameObject);
    }
    public List<GameObject> getObjects() {
        return objects;
    }
    // public List<String> getObjectsNames() {}
    public String getObjectsAsString(){
        String string;
        if (objects.isEmpty()){
            string = "This place is empty.";            
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < objects.size(); i++) {
                GameObject gameObject = objects.get(i);
                // sb.append(entry.getKey())
                sb.append(String.format("\n%d - ", i + 1));
                sb.append(gameObject.getName());
            }
            // for (Map.Entry<String, GameObject> entry : objects.entrySet()) {
            //     GameObject gameObject = entry.getValue();
            //     // sb.append(entry.getKey())
            //     sb.append("\n - ");
            //     sb.append(gameObject.getName());
            //         // .append("\n");
            // }
            string = sb.toString();
        }
        return string;
        
    }
    public GameObject getObject(int index) {
        GameObject object = objects.get(index);
        // GameObject object = objects.get(objectId);
        return object;
    }



    public Output inspect(){
        Output output = new Output();
        output.setSuccess(true);
        output.setMessage(String.format("%s \nObjects: %s", this.getDescription(), this.getObjectsAsString()));
        return output;
    }

}
