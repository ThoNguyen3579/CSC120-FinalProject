

public class searchableObject{
    String name;
    String description;
    int percentage;

    /**
     * constructor for searchableObject class
     * @param name
     * @param description
     * @param percentage
     */
    public searchableObject(String name, String description, int percentage){
        this.name = name; // name of the object
        this.description = description; // description about this object
        this.percentage = percentage; // the percentage of evidence that it contributes
    }

    /**
     * an overloadded constructor for objects that do not contribute as an evidence
     * @param name
     * @param description
     */
    public searchableObject(String name, String description){
        this.name = name; // name of the object
        this.description = description; // description about this object
    }

}
