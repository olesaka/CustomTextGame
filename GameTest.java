
/**
 * Test class that invokes the game class's methods.
 * 
 * @author Andrew Olesak 
 * @version November 23, 2015
 */
public class GameTest
{
    public static void main(String args[]){
        Game g = new Game();
        System.out.println(g.getMessage() + "\n");
        g.look();
        System.out.println(g.getMessage() + "\n");
        g.move("south");
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.move("north");
        System.out.println(g.getMessage() + "\n");
        g.move("north");
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.list();
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.move("sleep");
        System.out.println(g.getMessage() + "\n");
        g.help();
        System.out.println(g.getMessage() + "\n");
        g.eat("medicine");
        System.out.println(g.getMessage() + "\n");
        g.look();
        System.out.println(g.getMessage() + "\n");
        g.move("sleep");
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.spin("picture");
        System.out.println(g.getMessage() + "\n");
        g.spin("ring");
        System.out.println(g.getMessage() + "\n");
        g.move("sleep");
        System.out.println(g.getMessage() + "\n");
        g.move("wake");
        System.out.println(g.getMessage() + "\n");
        g.help();
        System.out.println(g.getMessage() + "\n");
        g.move("north");
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.move("west");
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.list();
        System.out.println(g.getMessage() + "\n");
        g.move("sleep");
        System.out.println(g.getMessage() + "\n");
        g.spin("ring");
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.shrink();
        System.out.println(g.getMessage() + "\n");
        g.pickup();
        System.out.println(g.getMessage() + "\n");
        g.move("sleep");
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.hypnotize("clock");
        System.out.println(g.getMessage() + "\n");
        g.move("east");
        System.out.println(g.getMessage() + "\n");
        g.drop("picture");
        System.out.println(g.getMessage() + "\n");
        g.gameOver();
        System.out.println(g.getMessage() + "\n");
    }
}
