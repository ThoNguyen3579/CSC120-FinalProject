import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameLoop{

    /**
     * constructor for the game loop
     */
    public GameLoop(){
        System.out.println("Beginning game loop!");

    }

    /**
     * a method that read files of text and print them out in the terminal as the game loop runs
     * @param pathname
     */
    public void readFile(String pathname){
        try{
                File myFile = new File(pathname);
                Scanner fileReader = new Scanner(myFile);

                // Loop until we run out of lines
                while(fileReader.hasNextLine()){
                    String data = fileReader.nextLine();
                    System.out.println("" + data);
                }

                fileReader.close();

                } catch (FileNotFoundException e){
                System.out.println("An error occured.");
                e.printStackTrace();
            }
            }
    

    public static void main(String[] args){
        GameLoop myGameLoop = new GameLoop();
        // Flag to let us know when the loop should end
        boolean stillPlaying = true;

        // initialize the maze
        System.out.println("Initializing maze ...");
        System.out.println("Successful.");
        Maze myMaze = new Maze();
        myMaze.buildMaze();
        myMaze.addSearchableObject();

        //create the player
        Player Tieu = new Player();

        // Scan the input for what files to read
        Scanner input = new Scanner(System.in); 

        System.out.println();
        System.out.println("Current number of cells: " +myMaze.listOfCells.size());

        myGameLoop.readFile("src\\Introduction.txt");

        myGameLoop.readFile("src\\MazeGuide.txt");

        // the start of the game loop!
        while (stillPlaying) { // while the player plays
            String response = input.nextLine().toUpperCase(); // take response if the player is still playing turn the input into a string and make all of them uppercase
            Tieu.goDirection(myMaze, response); // let player go around the maze
            if (Tieu.currentLocation == 14){ // main bedroom + private bathroom
                if (response.contains("LOOK")){ // look around the main bedroom
                    myGameLoop.readFile("src\\MainBedroom.txt");
                }
                for (int i = 0; i < myMaze.listOfCells.get(14).objects.size(); i++) { // allow user to search objects and collect evidence
                    if (response.contains("SEARCH " + myMaze.listOfCells.get(14).objects.get(i).name)){
                        System.out.println("Tieu Lau successfully searched the " + myMaze.listOfCells.get(14).objects.get(i).name + "!");
                        System.out.println(myMaze.listOfCells.get(14).objects.get(i).description);
                    }
                }
                if (response.contains("ENTER BATHROOM")){ // user enter bathroom
                    myGameLoop.readFile("src\\Bathroom.txt");
                }
                if(response.contains("SEARCH WALLET")){
                    System.out.println("Tieu Lau successfully searched the WALLET!");
                    System.out.println(myMaze.listOfCells.get(14).objects.get(4).description);
                }
                if(response.contains("SEARCH DRESSING TABLE")){
                    System.out.println("Tieu Lau successfully searched the DRESSING TABLE!");
                    System.out.println(myMaze.listOfCells.get(14).objects.get(5).description);
                }
            } else if (Tieu.currentLocation == 22){
                if (response.contains("LOOK")){ // allow user to look around
                    myGameLoop.readFile("src\\Kitchen.txt");
                }
                for (int i = 0; i < myMaze.listOfCells.get(22).objects.size(); i++) { // allow user to search objects
                    if (response.contains("SEARCH " + myMaze.listOfCells.get(22).objects.get(i).name)){
                        System.out.println(myMaze.listOfCells.get(22).objects.get(i).description);
                    }
                }
            } else if (Tieu.currentLocation == 30){
                myGameLoop.readFile("src\\Office.txt");
                for (int i = 0; i < myMaze.listOfCells.get(30).objects.size(); i++) {
                    if (response.contains("SEARCH "+myMaze.listOfCells.get(30).objects.get(i).name)){
                        System.out.println(myMaze.listOfCells.get(30).objects.get(i).description);
                    }
                    }
                if (response.contains("CODE "+ "0717")){
                        System.out.println("Safe in4");
                    }
            } else if (Tieu.currentLocation == 46){
                if (response.contains("LOOK")){
                myGameLoop.readFile("src\\ChildrenRoom.txt");
                }
                for (int i = 0; i < myMaze.listOfCells.get(46).objects.size(); i++) {
                    if (response.contains("SEARCH "+myMaze.listOfCells.get(46).objects.get(i).name)){
                        System.out.println(myMaze.listOfCells.get(46).objects.get(i).description);
                    }
                }
            } else if (Tieu.currentLocation == 48){
                System.out.println("System: [Who is the murderer? | Ha Vinh Cuong | Trieu Sam | Luu Van]?");
                if(response.contains("TRIEU SAM")){
                    System.out.println("YOU WIN!!!!!!");
                    stillPlaying = false;
                }
            } else if (Tieu.currentLocation == 9){
                System.out.println("x|9|2 \n3|x|7 \nx|x|6");
                if(response.contains("4581")){
                    System.out.println("Correct!");
                }
            } else if (Tieu.currentLocation == 18){
                System.out.println("4894 = 1236 \n9795 = 1645 \n7743 = 1412 \n8376 = ????");
                if (response.contains("1142")){
                    System.out.println("Correct!");
                }
            } else if (Tieu.currentLocation == 24){
                System.out.println("Left Down Right Down Left \nRight Down Left Down Right \n Left Down Down Right Up Left \nRight Down Down Left Up Up");
                if (response.contains("5260")){
                    System.out.println("Correct!");
                }
            } else if (Tieu.currentLocation == 27){
                System.out.println("What is the first digits for the three questions (3 digits in answer)?");
                if (response.contains("415")){
                    System.out.println("YOU WIN!!!");
                    stillPlaying = false;
                }
            } else if (response.equals("HELP")){
                myGameLoop.readFile("cheatsheet.md");
            }

        } 

}
}
