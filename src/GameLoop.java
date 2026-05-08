import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameLoop{

    /**
     * constructor for the game loop class
     */
    public GameLoop(){
    }

    /**
     * a method that read files of text and print them out in the terminal as the game loop runs
     * @param pathname
     */
    public void readFile(String pathname){
        try{
                File myFile = new File(pathname); 
                Scanner fileReader = new Scanner(myFile); // create a scanner that reads our file

                // read and print out the file information line by line
                // loop until we run out of lines
                while(fileReader.hasNextLine()){
                    String data = fileReader.nextLine(); // turn the Scanner information into a String
                    System.out.println("" + data);
                }

                // tidy up
                fileReader.close();

                // catch an error if there is anything not working
                } catch (FileNotFoundException e){
                System.out.println("An error occured.");
                e.printStackTrace();
            }
            }
    

    public static void main(String[] args){
        // create a new GameLoop
        GameLoop myGameLoop = new GameLoop();
        // flag to let us know when the loop should end
        boolean stillPlaying = true;

        // initialize the maze
        System.out.println("Initializing maze ...");
        System.out.println("Successful.");
        Maze myMaze = new Maze(); // create a new Maze
        myMaze.buildMaze(); // build the maze through adding cells to it
        myMaze.addSearchableObject(); // add searchable objects into specific cells that have clues

        //create the player
        Player Tieu = new Player();

        // Scan the input for what files to read
        Scanner input = new Scanner(System.in); 

        System.out.println();

        // print out the introduction file in the terminal
        myGameLoop.readFile("src\\Introduction.txt");
        // print out the maze guide in the terminal
        myGameLoop.readFile("src\\MazeGuide.txt");

        // the start of the game loop! This is a while loop that keeps asking for player response until the player wins the game
        while (stillPlaying) { // while the player is still playing
            // take response if the player is still playing, turn the response into a string and make all letters uppercase
            String response = input.nextLine().toUpperCase(); 

            // let player make permissible moves within the maze through taking in player's response on which direction thye want to go
            Tieu.goDirection(myMaze, response); 

            // these if statements allow player to interact with rooms and searchable objects
            // if player's current location is cell 14
            if (Tieu.currentLocation == 14){ // main bedroom + private bathroom
                // if they want to have a look around the room through the command "look"
                if (response.contains("LOOK")){ 
                    // print out the information about the main bedroom
                    myGameLoop.readFile("src\\MainBedroom.txt"); 
                }

                // within this bedroom (with private bathroom), create a for loop that allows player to search objects through the command "search"
                for (int i = 0; i < myMaze.listOfCells.get(14).objects.size(); i++) { 
                    // if the player response contains "search + object name", print out the information about that object
                    if (response.contains("SEARCH " + myMaze.listOfCells.get(14).objects.get(i).name)){
                        System.out.println("Tieu Lau successfully searched the " + myMaze.listOfCells.get(14).objects.get(i).name + "!");
                        System.out.println(myMaze.listOfCells.get(14).objects.get(i).description);
                    }
                }

                // if player enters the bathroom, print out the bathroom's information
                if (response.contains("ENTER BATHROOM")){ 
                    myGameLoop.readFile("src\\Bathroom.txt");
                }

                // if player search the wallet, print out information about what they found in it (the photograph)
                if(response.contains("SEARCH WALLET")){
                    System.out.println("Tieu Lau successfully searched the WALLET!");
                    System.out.println(myMaze.listOfCells.get(14).objects.get(4).description);
                }

                // if player search the dressing table, print out information about what they found in it (the perfume)
                if(response.contains("SEARCH DRESSING TABLE")){
                    System.out.println("Tieu Lau successfully searched the DRESSING TABLE!");
                    System.out.println(myMaze.listOfCells.get(14).objects.get(5).description);
                }

            // if player's current location is cell 22
            } else if (Tieu.currentLocation == 22){ // kitchen
                // if they want to have a look around the room through the command "look"
                if (response.contains("LOOK")){
                    // print out information about the kitchen
                    myGameLoop.readFile("src\\Kitchen.txt");
                }

                // within this kitchen, create a for loop that allows player to search objects through the command "search"
                for (int i = 0; i < myMaze.listOfCells.get(22).objects.size(); i++) { // allow user to search objects
                    if (response.contains("SEARCH " + myMaze.listOfCells.get(22).objects.get(i).name)){
                        System.out.println(myMaze.listOfCells.get(22).objects.get(i).description);
                    }
                }

            // if player's current location is cell 30
            } else if (Tieu.currentLocation == 30){ // office
                // if they want to have a look around the room through the command "look"
                if (response.contains("LOOK")){
                    // print out informaiton about the office
                    myGameLoop.readFile("src\\Office.txt");
                }

                // within this office, create a for loop that allows player to search objects except for the safe through the command "search" 
                for (int i = 0; i < myMaze.listOfCells.get(30).objects.size(); i++) {
                    if (i > 0){
                        if (response.contains("SEARCH "+myMaze.listOfCells.get(30).objects.get(i).name)){
                            System.out.println(myMaze.listOfCells.get(30).objects.get(i).description);
                        }
                    }
                }
                
                // if user manage to figure out the code for the safe
                if (response.contains("CODE "+ "0717") || response.contains("CODE "+ "[0717]")){
                    // print out the information about the safe
                        System.out.println(myMaze.listOfCells.get(30).objects.get(0).description);
                }

            // if player's current location is cell 46
            } else if (Tieu.currentLocation == 46){ // children's room
                // if they want to have a look around the room through the command "look"
                if (response.contains("LOOK")){
                    // print out the information about the children's room
                    myGameLoop.readFile("src\\ChildrenRoom.txt");

                // if they want to see the phone's information
                } else if (response.contains("SEARCH PHONE")){
                    // print out the phone's information in the terminal
                    myGameLoop.readFile("src\\phone.txt");
                }

                // within this children's room, create a for loop that allows player to search objects through the command "search"
                for (int i = 0; i < myMaze.listOfCells.get(46).objects.size(); i++) {
                    if (response.contains("SEARCH "+myMaze.listOfCells.get(46).objects.get(i).name)){
                        System.out.println(myMaze.listOfCells.get(46).objects.get(i).description);
                    }
                }

            // if player's current location is cell 48 (the Heart exit)
            } else if (Tieu.currentLocation == 48){
                // ask player the question about the heart chamber murder mystery
                System.out.println("System: [Who is the murderer? | Ha Vinh Cuong | Trieu Sam | Luu Van]?");
                // if the player manages to figure out who the murderer is
                if(response.contains("TRIEU SAM")){
                    // THEY WIN!!!
                    System.out.println("YOU WIN!!!!!!");
                    // stop the game loop
                    stillPlaying = false;
                }

            // if player's current location is cell 9 (a Diamond room)
            } else if (Tieu.currentLocation == 9){
                // print out the riddle in the terminal
                System.out.println("x|9|2 \n3|x|7 \nx|x|6");
                // if they manage to find out the answer, let them know that they are correct
                if(response.contains("4581")){
                    System.out.println("Correct!");
                }

            // if player's current location is cell 18 (a Diamond room)
            } else if (Tieu.currentLocation == 18){
                // print out the riddle in the terminal
                System.out.println("4894 = 1236 \n9795 = 1645 \n7743 = 1412 \n8376 = ????");
                // if they manage to find out the answer, let them know that they are correct
                if (response.contains("1142")){
                    System.out.println("Correct!");
                }

            // if player's current location is cell 24 (a Diamond room)
            } else if (Tieu.currentLocation == 24){
                // print out the riddle in the terminal
                System.out.println("Left Down Right Down Left \nRight Down Left Down Right \n Left Down Down Right Up Left \nRight Down Down Left Up Up");
                // if they manage to find out the answer, let them know that they are correct
                if (response.contains("5260")){
                    System.out.println("Correct!");
                }

            // if player's current location is cell 48 (the Diamond exit)
            } else if (Tieu.currentLocation == 27){
                // print out the question related to the riddles in the Diamond rooms
                System.out.println("What is the first digits for the three questions (3 digits in answer)?");
                // if they answer correctly
                if (response.contains("415")){
                    // THEY WIN!!!
                    System.out.println("YOU WIN!!!");   
                    // stop the game loop
                    stillPlaying = false;
                }

            // if player needs help during the game and enter the "help" command
            } else if (response.equals("HELP")){
                // print out the cheat sheet information
                myGameLoop.readFile("cheatsheet.md");
            }

        } 

}
}
