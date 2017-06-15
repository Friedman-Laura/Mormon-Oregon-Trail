/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Scanner;
import mormonoregontrail.control.GameControl;
import mormonoregontrail.model.Player;

/**
 *
 * @author Team
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
            "\n*******************************************************"
           +"\n*                                                     *"
           +"\n* Welcome to the Mormon Oregon Trail game!            *"
           +"\n*                                                     *"
           +"\n* This is a game that will take you on an adventure   *"
           +"\n* through the travels of the Mormon pioneers as they  *"
           +"\n* went from Nauvoo, Illinois to the Salt Lake Valley. *"
           +"\n*                                                     *"
           +"\n* You have to complete the adventure in less than     *"
           +"\n* 365 days. You will need to calculate resources      *"
           +"\n* needed based on the size of your group. You will    *"
           +"\n* encounter obstacles and challenges along the way.   *"
           +"\n*                                                     *"
           +"\n* You achieve success if you reach the Salt Lake      *"
           +"\n* Valley in the estimated time frame with resources   *"
           +"\n* left over.                                          *"
           +"\n*                                                     *"
           +"\n* Good luck and have fun on the Mormon Oregon Trail!  *"
           +"\n*                                                     *"
           +"\n*******************************************************"
           );
    }

    public void displayStartProgramView() {
        boolean done = false; // set flag to not done
        do {
            // Prompt for and get the player name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(playersName);
        
        } while (!done);
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if(player == null) { // if unsuccessful
            System.out.println("\nError creating the player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; // success !
    }

    private void displayNextView(Player player) {
        // display a custom welcome message
        System.out.println("\n========================================"
                          + "\n Welcome to the game " + player.getName()
                          + "\n We hope you have a lot of fun!"
                          + "\n======================================"
                          );
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
        // Display the main menu view
        mainMenuView.display();
    }
}
