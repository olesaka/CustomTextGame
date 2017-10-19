import java.util.HashMap;
/**
 * Maintains information about a room.
 * 
 * @author Andrew Olesak 
 * @version November 21, 2015
 */
public class Room
{
    private String description;
    private Item item;
    private HashMap<String, Room> myNeighbors;
    
    /**
     * Constructor that is passed the description of the room
     */
    public Room(String pDescription){
        this.description = pDescription;
        this.item = null;
        this.myNeighbors = new HashMap<String, Room>();
    }
    
    /**
     * Construcctor that is passed the description and the item of the room
     */
    public Room(String pDescription, Item pItem){
        this(pDescription);
        this.item = pItem;
    }
    
    /**
     * @return the description of the room
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * @return the item
     */
    public Item getItem(){
        return this.item;
    }
    
    /**
     * Add the provided item to the room.
     * 
     * @param i the item
     */
    public void addItem(Item i){
        this.item = i;
    }
    
    /**
     * @return true if the room has an item, otherwise false
     */
    public boolean hasItem(){
        if(this.item != null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Adds the provided room and corresponding direction to the hashmap
     * 
     * @param pDirection the direction
     * @param r the room
     */
    public void addNeighbor(String pDirection, Room r){
        this.myNeighbors.put(pDirection, r);
    }
    
    /**
     * Finds the room in the given direction
     * 
     * @param pDirection the direction
     * @return the adjacent room in the request direction, otherwise 
     * null if there is no room in that direction
     * 
     */
    public Room getNeighbor(String pDirection){
        Room room = this.myNeighbors.get(pDirection);
        if(room != null){
            return room;
        }
        return null;
    }
    
    /**
     * Removes the item
     * 
     * @return the item that was removed
     */
    public Item removeItem(){
        Item object = null;
        if(this.item != null){
            object = this.item;
            this.item = null;
            return object;
        }
        return null;
    }
    
    /**
     * @return a string prefix for the room and another if the room has an item
     */
    public String getLongDescription(){
        String str = "";
        if(this.item == null){
            str = "You are " + this.description;
        }else{
            str = "You are " + this.description + "\n" + "You see " + this.item.getDescription();
        }
        return str;
    }
}
