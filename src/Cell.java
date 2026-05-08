import java.util.ArrayList;
import java.util.List;

public class Cell {
    List<Integer> walls;
    boolean heartRoom;
    boolean diamondRoom;
    ArrayList<searchableObject> objects; //list of item


    /**
     * Constructor for the cell
     * @param leftWall
     * @param upWall
     * @param rightWall
     * @param downWall
     * @param heartRoom
     * @param diamondRoom
     */
    public Cell(Integer leftWall, Integer upWall, Integer rightWall, Integer downWall, boolean heartRoom, boolean diamondRoom){
        this.walls = new ArrayList<Integer>();
        this.walls.add(leftWall);
        this.walls.add(upWall);
        this.walls.add(rightWall);
        this.walls.add(downWall);
        this.heartRoom = heartRoom; 
        this.diamondRoom = diamondRoom;
        this.objects = new ArrayList<searchableObject>();
    }

    /**
     * print out announcement to let player know that they have entered a Heart or Diamond room 
     */
    public void specifyRoom(){
        if (this.heartRoom == true){
            System.out.println("─── Secret Chamber Heart: The Rose Funeral ───");
        } else if (this.diamondRoom == true){
            System.out.println("─── Secret Chamber Diamond: The Number Matrix ───");
        }
    }

}
