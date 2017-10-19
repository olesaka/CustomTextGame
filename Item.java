
/**
 * Class maintains information about an item.
 * 
 * @author Andrew Olesak 
 * @version November 21, 2015
 */
public class Item
{
    private String name;
    private String description;
    private int weight;
    private boolean edible;
    private boolean spin;
    private boolean hypnotize;

    /**
     * Constructor sets parameters to the instance variables.
     * 
     * @param n the name of the item
     * @param d the description of the item
     * @param w the weight of the item
     * @param e whether the item is edible
     * @param s whether the item can be spun
     * @param h whether the item can be used to hypnotize
     */
    public Item(String n, String d, int w, boolean e, boolean s, boolean h){
        this.name = n;
        this.description = d;
        this.weight = w;
        this.edible = e;
        this.spin = s;
        this.hypnotize = h;
    }

    /**
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return the description of the item
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * @return the weight of the item
     */
    public int getWeight(){
        return this.weight;
    }

    /**
     * @return whether the item is edible
     */
    public boolean getEdible(){
        return this.edible;
    }

    /**
     * @return whether the item can be spun
     */
    public boolean getSpin(){
        return this.spin;
    }

    /**
     * @return whether the item can be used to hypnotize
     */
    public boolean getHypnotize(){
        return this.hypnotize;
    }

    /**
     * Sets the name of the item
     * 
     * @param n the name of the item
     */
    public void setName(String n){
        this.name = n;
    }

    /**
     * Sets the description of the item
     * 
     * @param d the description of the item
     */
    public void setDescription(String d){
        this.description = d;
    }

    /**
     * Sets the weight of the item
     * 
     * @param w the weight of the item
     */
    public void setWeight(int w){
        this.weight = w;
    }

    /**
     * Sets whether the item is edible
     * 
     * @param e true if the item is edible, otherwise false
     */
    public void setEdible(boolean e){
        this.edible = e;
    }

    /**
     * Sets whether the item can spin
     * 
     * @param s true if the item can spin, otherwise false
     */
    public void setSpin(boolean s){
        this.spin = s;
    }

    /**
     * Sets whether the item can be used to hypnotize other people
     * 
     * @param h true if the item can be used to hypnotize, otherwise false
     */
    public void setHypnotize(boolean h){
        this.hypnotize = h;
    }

    /**
     * @return true if the item can be used to hypnotize people, otherwise false
     */
    public boolean canHypnotize(){
        if(this.hypnotize){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return true if the item can spin, otherwise false
     */
    public boolean canSpin(){
        if(this.spin){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return true if the item is edible.  Otherwise return false
     */
    public boolean isEdible(){
        if(this.edible){
            return true;
        }else{
            return false;
        }
    }
}
