import java.util.*;
import java.util.Random;
/**
 * Keeps track of the player's items and the current location.
 * 
 * @author Andrew Olesak
 * @version November 21, 2015
 */
public class Game
{
    private Room hotelRoom;
    private Room bathroom;
    private Room lobby;
    private Room bar;
    private Room kitchen;
    private Room library;
    private Room lab;
    private Room conferenceRoom;
    private Room office;
    private Item picture;
    private Item clock;
    private Item medicine;
    private Item ring;
    private ArrayList<Item> items;
    private Room currentLocation;
    private String currentMessage;
    private boolean medicineEaten;
    private boolean hypnotized;

    /**
     * Constructor sets values to the instance variables
     */
    public Game(){
        this.createRooms();
        this.items = new ArrayList<Item>();
        this.currentLocation = this.hotelRoom;
        this.setWelcomeMessage();
        this.medicineEaten = false;
        this.hypnotized = false;
    }

    /**
     * @return the picture
     */
    public Item getPicture(){
        return this.picture;
    }

    /**
     * @return the size of the arraylist items
     */
    public int getArrayListItemsSize(){
        return this.items.size();
    }

    /**
     * @return the library
     */
    public Room getLibrary(){
        return this.library;
    }

    /**
     * @return the lobby
     */
    public Room getLobby(){
        return this.lobby;
    }

    /**
     * @return the bar
     */
    public Room getBar(){
        return this.bar;
    }

    /**
     * @return the office
     */
    public Room getOffice(){
        return this.office;
    }

    /**
     * @return the hotel room
     */
    public Room getHotelRoom(){
        return this.hotelRoom;
    }

    /**
     * @return the bathroom
     */
    public Room getBathroom(){
        return this.bathroom;
    }

    /**
     * Sets the current location to the given parameter
     * 
     * @param room the room
     */
    public void setCurrentLocation(Room room){
        this.currentLocation = room;
    }

    /**
     * @return a description of the current location
     */
    public String getRoomDescription(){
        this.currentMessage = this.currentLocation.getLongDescription();
        return this.currentMessage;
    }

    /**
     * @return the current location
     */
    public Room getCurrentLocation(){
        return this.currentLocation;
    }

    /**
     * @return the game's current message
     */
    public String getMessage(){
        return this.currentMessage;
    }

    /**
     * Instantiates the rooms and items
     */
    private void createRooms(){

        // create the items
        this.picture = new Item("picture", "a picture of a woman", 1, false, false, false);
        this.clock = new Item("clock", "a pendulum clock", 80, false, false, true);
        this.medicine = new Item("medicine", "a bottle of sedation medicine", 2, true, false, false);
        this.ring = new Item("ring", "a gold ring", 1, false, true, false);

        // create the rooms and whether they have objects in them
        this.hotelRoom = new Room("in a messy hotel room");
        this.bathroom = new Room("in a bathroom with containers on the counter", this.medicine);
        this.lobby = new Room("in a lobby with a jewelry set on a chair", this.ring);
        this.bar = new Room("in a bar with a tack board full of pictures", this.picture);
        this.kitchen = new Room("in a nice clean kitchen");
        this.library = new Room("in a large library", this.clock);
        this.lab = new Room("in a hot computer lab");
        this.conferenceRoom = new Room("in a conference room with a man by a door");
        this.office = new Room("in an office that has a desk in the middle");

        // create the room's neighbors
        this.hotelRoom.addNeighbor("south", this.bathroom);
        this.hotelRoom.addNeighbor("north", this.lobby);
        this.hotelRoom.addNeighbor("sleep", this.bar);
        this.bathroom.addNeighbor("north", this.hotelRoom);
        this.bathroom.addNeighbor("sleep", this.bar);
        this.lobby.addNeighbor("south", this.hotelRoom);
        this.lobby.addNeighbor("sleep", this.bar);
        this.bar.addNeighbor("east", this.kitchen);
        this.bar.addNeighbor("sleep", this.lab);
        this.bar.addNeighbor("wake", this.hotelRoom);
        this.kitchen.addNeighbor("west", this.bar);
        this.kitchen.addNeighbor("sleep", this.lab);
        this.kitchen.addNeighbor("wake", this.hotelRoom);
        this.lab.addNeighbor("east", this.library);
        this.lab.addNeighbor("sleep", this.conferenceRoom);
        this.lab.addNeighbor("wake", this.bar);
        this.library.addNeighbor("west", this.lab);
        this.library.addNeighbor("sleep", this.conferenceRoom);
        this.library.addNeighbor("wake", this.bar);
        this.conferenceRoom.addNeighbor("east", this.office);
        this.conferenceRoom.addNeighbor("wake", this.lab);
        this.office.addNeighbor("west", this.conferenceRoom);
        this.office.addNeighbor("wake", this.lab);
    }

    /**
     * Initializes the game's message with a description of the game.
     */
    private void setWelcomeMessage(){
        this.currentMessage = "Welcome to the game of Inception!  The objective of the game " +
        "is to make it\nthree dreams deep in order to give a businessman an idea about a girl.";
    }

    /**
     * Checks the ArrayList for the requested item name
     * 
     * @param name the name of the item
     * @return the item if found, otherwise null
     */
    private Item checkForItem(String name){
        for(Item i : this.items){
            if(i.getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return null;
    }

    /**
     * Updates the game's message to display hints, suggestions, and reminders about the game
     */
    public void help(){
        Random rand = new Random();
        int val = rand.nextInt(6);
        switch(val){
            case 0:
            this.currentMessage = "You have to be sedated before you can start sleeping";
            break;

            case 1:
            this.currentMessage = "You have to sleep to make it to all of the rooms";
            break;

            case 2:
            this.currentMessage = "If you spin the ring, it will tell you how many " +
            "dreams deep you are";
            break;

            case 3:
            this.currentMessage = "If you drop the clock, the pendulum can be used to " +
            "hypnotize people";
            break;

            case 4:
            this.currentMessage = "The idea you need to implant has to do with the " +
            "girl in the picture";
            break;

            case 5:
            this.currentMessage = "You have to be three dreams deep in order to complete " +
            "inception";
            break;
        }
        return;
    }

    /**
     * Updates the game's current message with the current room's long description
     */
    public void look(){
        this.currentMessage = this.currentLocation.getLongDescription();
    }

    /**
     * If appropriate, upadate the current location with the neighbor
     * in the requested location.
     * 
     * @param direction the direction
     */
    public void move(String direction){
        Room nextRoom = this.currentLocation.getNeighbor(direction);
        String sleep = "sleep";
        if(nextRoom == null){
            this.currentMessage = "You can't go in that direction";
        }else if(!this.medicineEaten && direction == sleep){
            this.currentMessage = "You can't sleep without consuming sedation medicine";
        }else if(!this.hypnotized && nextRoom == this.office){
            this.currentMessage = "You can't get to the next room because the man is " +
            "guarding the door";
        }else{
            this.currentLocation = nextRoom;
            this.currentMessage = this.currentLocation.getLongDescription();
        }
    }

    /**
     * Updates the game's message with a list of all items that the player is holding
     */
    public void list(){
        String str = "You are holding:\n";
        if(this.items.size() == 0){
            this.currentMessage = "You are not currently holding any items";
        }else{
            for(Item i : this.items){
                str += "     " + i.getDescription() + "\n";
            }
            this.currentMessage = str;
        }
    }

    /**
     * If appropriate, remove the item from the room and add to array list
     */
    public void pickup(){
        Item object = this.currentLocation.getItem();
        if(object == null){
            this.currentMessage = "There is no item in the room to take";
        }else if(object.getWeight() > 50){
            this.currentMessage = "The item is too heavy to pick up";
        }else{
            this.currentLocation.removeItem();
            this.items.add(object);
            this.currentMessage = "You are now holding the " + object.getName();
        }
    }

    /**
     * If appropriate, remove the item from the 
     * arraylist and add it to the current room
     * 
     * @param item the item to be dropped
     */
    public void drop(String item){
        Item object = this.checkForItem(item);
        if(object == null){
            this.currentMessage = "You are not holding that item";
        }else if(this.currentLocation.getItem() != null){
            this.currentMessage = "The room already has an item";
        }else{
            this.currentLocation.addItem(object);
            this.items.remove(object);
            if(this.currentLocation == this.office && object == this.picture){
                this.currentMessage = "You have successfully dropped the " + object.getName() +
                " on the desk";
            }else{
                this.currentMessage = "You have successfully dropped the " + object.getName() +  
                " in the room";
            }
        }
    }

    /**
     * Allows the player to eat an item if they have it and it is edible
     * 
     * @param item the item to be eaten
     */
    public void eat(String item){
        Item object = this.checkForItem(item);
        if(object == null){
            this.currentMessage = "You are not holding that item";
        }else if(!object.isEdible()){
            this.currentMessage = "The item is not edible";
        }else{
            this.items.remove(object);
            this.currentMessage = "You have successfully eaten the " + object.getName() + 
            " and are no longer holding it";
            if(object == this.medicine){
                this.medicineEaten = true;
            }
        }
    }

    /**
     * Determines if the game has been won
     * 
     * @return true if the game has been won, otherwise false
     */
    public boolean gameOver(){
        if(this.office.getItem() == this.picture){
            this.currentMessage = "Congratulations!  You have successfully completed Inception";
            return true;
        }else{
            return false;
        }
    }

    /**
     * Allows the player to shrink an object that is too heavy to pick up
     */
    public void shrink(){
        Item object = this.currentLocation.getItem();
        if(object == null){
            this.currentMessage = "There is no item in this room to shrink";
        }else if(object.getWeight() > 50){
            object.setWeight(5);
            this.currentMessage = "You shrunk the " + object.getName() + " and can pick " +
            "it up now";
        }else{
            this.currentMessage = "The " + object.getName() + " is light enough to pick up";
        }
    }

    /**
     * Allows the player to spin an object that can spin
     * 
     * @param item the item the player wants to spin
     */
    public void spin(String item){
        Item object = this.checkForItem(item);
        if(object == null){
            this.currentMessage = "You are not holding that item";
        }else if(object.canSpin()){
            if(this.currentLocation == this.hotelRoom || 
            this.currentLocation == this.bathroom || this.currentLocation == this.lobby){
                this.currentMessage = "You are not dreaming yet";
            }else if(this.currentLocation == this.bar || this.currentLocation == this.kitchen){
                this.currentMessage = "You are one dream deep";
            }else if(this.currentLocation == this.library || this.currentLocation == this.lab){
                this.currentMessage = "You are two dreams deep";
            }else{
                this.currentMessage = "You are three dreams deep";
            }
        }else{
            this.currentMessage = "You can't spin the " + object.getName();
        }
    }

    /**
     * Allows the player to hypnotize someone if there is someone to hypnotize
     * and the item can be used to hypnotize someone.
     * 
     * @param item the item the player wants to use to hypnotize
     */
    public void hypnotize(String item){
        Item object = this.checkForItem(item);
        if(object == null){
            this.currentMessage = "You are not holding that item";
        }else if(object.canHypnotize()){
            if(!this.hypnotized && this.currentLocation == this.conferenceRoom){
                this.hypnotized = true;
                this.currentMessage = "You have successfully hypnotized the man";
            }else if(this.hypnotized && this.currentLocation == this.conferenceRoom){
                this.currentMessage = "You have already hypnotized the man";
            }else{
                this.currentMessage = "There is no one in this room to hypnotize";
            }
        }else{
            this.currentMessage = "You can't hypnotize anyone with that item";
        }
    }
}