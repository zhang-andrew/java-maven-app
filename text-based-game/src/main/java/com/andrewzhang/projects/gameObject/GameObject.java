package com.andrewzhang.projects.gameObject;

import java.util.UUID;
import com.andrewzhang.projects.domain.Output;

public class GameObject {
    private String objectId;
    private String name;
    private String description;
    private boolean isHidden = false;

    public GameObject(String name, String description){
        this.objectId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }

    // objectId getter
    public String getObjectId() {
        return objectId;
    }

    // name getter/setter
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // description getter/setter
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    // hidden getter/setter
    public boolean isHidden(){
        return isHidden;
    }
    public void setHidden(boolean state){
        this.isHidden = state;
    }


    //action verbs
    public Output inspect(){
        Output output = new Output();
        output.setSuccess(true);
        output.setMessage(this.getDescription());
        return output;
    }

}
