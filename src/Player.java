
public class Player {
    public int currentLocation;
    public Maze maze;

    /**
     * constructor for Player
     */
    public Player(){
        this.currentLocation = 0; // current location (cell) that the player is in; initially,they are in cell 0
        this.maze = new Maze(); // the maze that the player is in
    }

    /**
     * move player to different directions (up,down,right,left) according to their input
     * if that direction of moving has a wall blocking the way, user cannot move
     * @param maze
     */
    public void goDirection(Maze maze, String direction){
        // if the player wants to go up, 
        // check if their current location allows them to go up
        // then check if they will bump into a wall if they go up
        // if all of the above is satisfied, move their current location up
        if (direction.contains("GO UP")){ 
            if (this.currentLocation > 6){
                if (maze.listOfCells.get(this.currentLocation).walls.get(1) == 0) {
                    this.currentLocation -= 7;
                    System.out.println("You are at cell " + this.currentLocation + ".");
                } else {
                    System.out.println("You hit a Wall.");
                }
            }



        // if the player wants to go down, 
        // check if their current location allows them to go down
        // then check if they will bump into a wall if they go down
        // if all of the above is satisfied, move their current location down
        } else if (direction.contains("GO DOWN")){
            if (this.currentLocation < 42){
                if (maze.listOfCells.get(this.currentLocation).walls.get(3) == 0) {
                    this.currentLocation += 7;
                    System.out.println("You are at cell " + this.currentLocation + ".");
                } else {
                    System.out.println("You hit a Wall.");
                }
            }

        // if the player wants to go left, 
        // check if their current location allows them to go left
        // then check if they will bump into a wall if they go left
        // if all of the above is satisfied, move their current location left
        } else if (direction.contains("GO LEFT")){
            if (this.currentLocation > 0){
                if (maze.listOfCells.get(this.currentLocation).walls.get(0) == 0) {
                    this.currentLocation -= 1;
                    System.out.println("You are at cell " + this.currentLocation + ".");
                } else {
                    System.out.println("You hit a Wall.");
                }
            }

        
        // if the player wants to go right, 
        // check if they will bump into a wall if they go right
        // if no, move their current location right        
        } else if (direction.contains("GO RIGHT")){
            if (maze.listOfCells.get(this.currentLocation).walls.get(2) == 0) {
                this.currentLocation += 1;
                System.out.println("You are at cell " + this.currentLocation + ".");
            } else {
                System.out.println("You hit a Wall.");
            }
        }

        // print out the current location every time the player moves
        System.out.println("Current location: "+ this.currentLocation);
        // if they enter a heart room or diamond room, let them know
        maze.listOfCells.get(this.currentLocation).specifyRoom();
    }

        }

