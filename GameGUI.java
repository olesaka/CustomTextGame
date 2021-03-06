import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.DefaultCaret;
/**
 * Creates a GUI and allows the user to interact with the game class.
 * 
 * @author Andrew Olesak 
 * @version November 25, 2015
 */
public class GameGUI extends JFrame implements ActionListener
{

    // create object to refer to the game class
    Game myGame;

    // define the game buttons
    private JButton northButton;
    private JButton eastButton;
    private JButton southButton;
    private JButton westButton;
    private JButton sleepButton;
    private JButton wakeButton;
    private JButton helpButton;
    private JButton pickupButton;
    private JButton dropButton;
    private JButton eatButton;
    private JButton lookButton;
    private JButton listButton;
    private JButton shrinkButton;
    private JButton spinButton;
    private JButton hypnotizeButton;

    // create a results area
    JTextArea results;

    // create menu items
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem newGameItem;
    JMenuItem quitItem;

    /**
     * Main Method
     */
    public static void main(String args[]){
        GameGUI graphic = new GameGUI();
        graphic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphic.setTitle("Inception Puzzle Game");
        graphic.pack();
        graphic.setVisible(true);
    }

    /**
     * Constructor creates and places the instance variables on the JFrame
     */
    public GameGUI(){

        // instantiate the game object
        this.myGame = new Game();

        // set the layout for the gridbag
        setLayout(new GridBagLayout());
        GridBagConstraints place = new GridBagConstraints();

        // create and place the results text area
        this.results = new JTextArea(25, 60);
        JScrollPane scrollPane = new JScrollPane(this.results);
        DefaultCaret caret = (DefaultCaret)this.results.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        this.results.setEditable(false);
        place.gridx = 0;
        place.gridy = 0;
        place.insets.left = 20;
        place.insets.bottom = 20;
        place.insets.right = 20;
        add(scrollPane, place);
        results.append(myGame.getMessage() + "\n\n");
        results.append(myGame.getRoomDescription() + "\n\n");

        // create the directions label
        place.gridx = 1;
        place.gridy = 0;
        place.anchor = GridBagConstraints.NORTH;
        place.insets.top = 10;
        place.insets.left = -5;
        place.insets.right = 20;
        add(new JLabel("Directions"), place);

        // create and place the north button
        this.northButton = new JButton("North");
        this.northButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 35;
        add(this.northButton, place);

        // create and place the south button
        this.southButton = new JButton("South");
        this.southButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 75;
        add(this.southButton, place);

        // create and place the east button
        this.eastButton = new JButton("East");
        this.eastButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 115;
        add(this.eastButton, place);

        // create and place the west button
        this.westButton = new JButton("West");
        this.westButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 155;
        add(this.westButton, place);

        // create and place the sleep button
        this.sleepButton = new JButton("sleep");
        this.sleepButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 195;
        add(this.sleepButton, place);

        // create and place the wake button
        this.wakeButton = new JButton("wake");
        this.wakeButton.setBackground(Color.CYAN);
        place.gridx = 1;
        place.gridy = 0;
        place.insets.top = 235;
        add(this.wakeButton, place);

        // create the actions label
        place.gridx = 0;
        place.gridy = 1;
        place.anchor = GridBagConstraints.WEST;
        place.insets.left = 10;
        place.insets.top = 0;
        add(new JLabel("Actions:"), place);

        // create and place the help button
        this.helpButton = new JButton("help");
        this.helpButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 65;
        add(this.helpButton, place);

        // create and place the pickup button
        this.pickupButton = new JButton("pickup");
        this.pickupButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 130;
        add(this.pickupButton, place);

        // create and place the drop button
        this.dropButton = new JButton("drop");
        this.dropButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 210;
        add(this.dropButton, place);

        // create and place the eat button
        this.eatButton = new JButton("eat");
        this.eatButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 278;
        add(this.eatButton, place);

        // create and place the look button
        this.lookButton = new JButton("look");
        this.lookButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 338;
        add(this.lookButton, place);

        // create and place the list button
        this.listButton = new JButton("list");
        this.listButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 405;
        add(this.listButton, place);

        // create and place the shrink button
        this.shrinkButton = new JButton("shrink");
        this.shrinkButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 465;
        add(this.shrinkButton, place);
        
        // create and place the spin button
        this.spinButton = new JButton("spin");
        this.spinButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 545;
        add(this.spinButton, place);
        
        // create and place the hypnotize button
        this.hypnotizeButton = new JButton("hypnotize");
        this.hypnotizeButton.setBackground(Color.GREEN);
        place.gridx = 0;
        place.gridy = 1;
        place.insets.left = 612;
        add(this.hypnotizeButton, place);

        // create the file menu
        this.fileMenu = new JMenu("File");
        this.newGameItem = new JMenuItem("new game");
        this.quitItem = new JMenuItem("quit");
        fileMenu.add(this.newGameItem);
        fileMenu.add(quitItem);
        this.menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // register the listeners for the buttons
        this.northButton.addActionListener(this);
        this.southButton.addActionListener(this);
        this.eastButton.addActionListener(this);
        this.westButton.addActionListener(this);
        this.helpButton.addActionListener(this);
        this.pickupButton.addActionListener(this);
        this.dropButton.addActionListener(this);
        this.eatButton.addActionListener(this);
        this.lookButton.addActionListener(this);
        this.listButton.addActionListener(this);
        this.sleepButton.addActionListener(this);
        this.wakeButton.addActionListener(this);
        this.shrinkButton.addActionListener(this);
        this.spinButton.addActionListener(this);
        this.hypnotizeButton.addActionListener(this);

        // add action listeners for the menu items
        this.newGameItem.addActionListener(this);
        this.quitItem.addActionListener(this);
    }

    /**
     * Allows the player to move to the next room
     * 
     * @param direction the direction the player wishes to move
     */
    public void moveDirection(String direction){
        this.myGame.move(direction);
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Gives the player hints about the game
     */
    public void helpPlayer(){
        myGame.help();
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the player to pickup an item if there is an item to pick up
     */
    public void pickupItem(){
        myGame.pickup();
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the player to drop an item if the room doesn't already contain an item
     */
    public void dropItem(){
        String str = JOptionPane.showInputDialog(null,"Drop?");
        myGame.drop(str);
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the user to eat an item if they are holding it
     */
    public void eatItem(){
        String str = JOptionPane.showInputDialog(null, "Eat?");
        myGame.eat(str);
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the player to get a room description
     */
    public void lookAround(){
        myGame.look();
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Shows a list of all the items that the player is currently holding
     */
    public void listItems(){
        myGame.list();
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the player to shrink an item that is too heavy to pick up
     */
    public void shrinkItem(){
        myGame.shrink();
        results.append(this.myGame.getMessage() + "\n\n");
    }

    /**
     * Allows the player to spin an item that can be spun
     */
    public void spinItem(){
        String str = JOptionPane.showInputDialog(null, "Spin?");
        myGame.spin(str);
        results.append(this.myGame.getMessage() + "\n\n");
    }
    
    /**
     * Allows the player to hypnotize someone 
     */
    public void hypnotize(){
        String str = JOptionPane.showInputDialog(null, "Use to hypnotize?");
        myGame.hypnotize(str);
        results.append(this.myGame.getMessage() + "\n\n");
    }
    
    /**
     * Disables all the buttons
     * Called when the game is over
     */
    private void gameOver(){
        if(myGame.gameOver()){
            this.northButton.setEnabled(false);
            this.southButton.setEnabled(false);
            this.eastButton.setEnabled(false);
            this.westButton.setEnabled(false);
            this.sleepButton.setEnabled(false);
            this.wakeButton.setEnabled(false);
            this.helpButton.setEnabled(false);
            this.pickupButton.setEnabled(false);
            this.dropButton.setEnabled(false);
            this.eatButton.setEnabled(false);
            this.lookButton.setEnabled(false);
            this.listButton.setEnabled(false);
            this.shrinkButton.setEnabled(false);
            this.spinButton.setEnabled(false);
            this.hypnotizeButton.setEnabled(false);
            
            // lets the player know they have won the game
            JOptionPane.showMessageDialog(null, this.myGame.getMessage());
        }
    }

    /**
     * Restarts the game
     */
    private void newGame(){

        // enable all of the buttons
        this.northButton.setEnabled(true);
        this.southButton.setEnabled(true);
        this.eastButton.setEnabled(true);
        this.westButton.setEnabled(true);
        this.sleepButton.setEnabled(true);
        this.wakeButton.setEnabled(true);
        this.helpButton.setEnabled(true);
        this.pickupButton.setEnabled(true);
        this.dropButton.setEnabled(true);
        this.eatButton.setEnabled(true);
        this.lookButton.setEnabled(true);
        this.listButton.setEnabled(true);
        this.shrinkButton.setEnabled(true);
        this.spinButton.setEnabled(true);
        this.hypnotizeButton.setEnabled(true);

        // creates a new game object
        myGame = new Game();

        // display the wecome message and the first location
        this.results.setText("");
        this.results.append(myGame.getMessage() + "\n\n");
        this.results.append(myGame.getRoomDescription() + "\n\n");
    }

    /**
     * Method is called any time a button is pressed. Internal method is called accordinally
     * 
     * @param e the event that was fired
     */
    public void actionPerformed(ActionEvent e){

        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        // react to the north button pressed
        if(e.getSource() == this.northButton){
            this.moveDirection("north");
        }

        // react to the south button pressed
        if(e.getSource() == this.southButton){
            this.moveDirection("south");   
        }

        // react to the east button pressed
        if(e.getSource() == this.eastButton){
            this.moveDirection("east");
        }

        // react to the west button pressed
        if(e.getSource() == this.westButton){
            this.moveDirection("west");
        }

        // react to the sleep button pressed
        if(e.getSource() == this.sleepButton){
            this.moveDirection("sleep");
        }

        // react to the wake button pressed
        if(e.getSource() == this.wakeButton){
            this.moveDirection("wake");
        }

        // react to the help button pressed
        if(e.getSource() == this.helpButton){
            this.helpPlayer();
        }

        // react to the pickup button pressed
        if(e.getSource() == this.pickupButton){
            this.pickupItem();
        }

        // react to the drop button pressed
        if(e.getSource() == this.dropButton){
            this.dropItem();
        }

        // react to the eat buttton pressed
        if(e.getSource() == this.eatButton){
            this.eatItem();
        }

        // react to the look button pressed
        if(e.getSource() == this.lookButton){
            this.lookAround();
        }

        // react to the list button pressed
        if(e.getSource() == this.listButton){
            this.listItems();
        }

        // react to the shrink button pressed
        if(e.getSource() == this.shrinkButton){
            this.shrinkItem();
        }
        
        // react to the spin button pressed
        if(e.getSource() == this.spinButton){
            this.spinItem();
        }

        // react to the hypnotize button pressed
        if(e.getSource() == this.hypnotizeButton){
            this.hypnotize();
        }
  
        // react to file/quit menu item pressed
        if(e.getSource() == quitItem){
            dispose();
        }

        // react to the file/new game menu item pressed
        if(e.getSource() == newGameItem){
            this.newGame();
        }
        
        // checks to see if the game has been won
        this.gameOver();
    }
}
