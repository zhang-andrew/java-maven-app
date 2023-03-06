package com.andrewzhang.projects;

import com.andrewzhang.projects.managers.GameManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // instantiate gameManager singleton instance
        GameManager gameManager = GameManager.getInstance();
        gameManager.launch();
    }
}
