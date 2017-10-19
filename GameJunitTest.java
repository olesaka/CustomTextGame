
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameJunitTest.
 *
 * @author  Andrew Olesak
 * @version November 22, 2015
 */
public class GameJunitTest
{
    private Item testItem;
    private Room testRoom;
    private Game testGame;

    /**
     * Default constructor for test class GameTest
     */
    public GameJunitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        testItem = new Item("medicine", "a bottle of sedation medicine", 1, true, false, false);
        testRoom = new Room("in a bathroom with bottles all over the counter", this.testItem);
        testGame = new Game();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetWeightShouldBeOne(){
        Assert.assertEquals("Should be one", 1, this.testItem.getWeight());
    }
    
    @Test
    public void testCanSpinShouldReturnFalse(){
        Assert.assertFalse("Should be false", this.testItem.canSpin());
    }
    
    @Test
    public void testIsEdibleShoulReturnTrue(){
        Assert.assertTrue("Should return true", this.testItem.isEdible());
    }

    @Test
    public void testAddItemShouldBeMedicine(){
        this.testRoom.addItem(this.testItem);
        Assert.assertEquals("Should be medicine", this.testItem, this.testRoom.getItem());
    }
    
    @Test
    public void testHasItemShouldReturnTrue(){
        Assert.assertTrue("Should return true", this.testRoom.hasItem());
    }

    @Test
    public void testGetNeighborShouldBeNull(){
        Assert.assertNull("Should be null", this.testRoom.getNeighbor("southwest"));
    }
    
    @Test
    public void testRemoveItemShouldBeNotBeNull(){
        Assert.assertNotNull("Should be null", this.testRoom.removeItem());
    }
    
    @Test
    public void testGetNeightborShouldBeNull(){
        Assert.assertNull("Should be null", this.testRoom.getNeighbor("east"));
    }
    
    @Test
    public void testremoveItemShouldNotBeNull(){
        Assert.assertNotNull("Should be medicine", this.testRoom.removeItem());
    }

    @Test
    public void testGetLongDescriptionShouldNotBeNull(){
        Assert.assertNotNull("Should be a description of a bathroom with a bottle on the counter",
        this.testRoom.getLongDescription());
    }
    
    @Test
    public void testMoveShouldBeTheBar(){
        this.testGame.setCurrentLocation(this.testGame.getBathroom());
        this.testGame.pickup();
        this.testGame.eat("medicine");
        this.testGame.move("sleep");
        Assert.assertEquals("Should be Bar", this.testGame.getBar(), this.testGame.
        getCurrentLocation());
    }
    
    @Test
    public void testGameOverShouldBeTrue(){
        this.testGame.setCurrentLocation(this.testGame.getBar());
        this.testGame.pickup();
        this.testGame.setCurrentLocation(this.testGame.getOffice());
        this.testGame.drop("picture");
        Assert.assertTrue("Should be true", this.testGame.gameOver());
    }
    
    @Test
    public void testPickupShouldLeaveRoomNull(){
        this.testGame.setCurrentLocation(this.testGame.getBar());
        this.testGame.pickup();
        Room room = this.testGame.getCurrentLocation();
        Assert.assertNull("Should be null", room.getItem());
    }
    
    @Test
    public void testShrinkShouldSetWeightToZero(){
        this.testGame.setCurrentLocation(this.testGame.getLibrary());
        this.testGame.shrink();
        Room room = this.testGame.getCurrentLocation();
        Item item = room.getItem();
        Assert.assertEquals("Should be zero", 5, item.getWeight());
    }
    
    @Test
    public void testEatShouldReturnListOfITemsOfZero(){
        this.testGame.setCurrentLocation(this.testGame.getBathroom());
        this.testGame.pickup();
        this.testGame.eat("medicine");
        Assert.assertEquals("Should be zero", 0, this.testGame.getArrayListItemsSize());
    }
    
    @Test
    public void testListShouldReturnSizeThree(){
        this.testGame.setCurrentLocation(this.testGame.getBathroom());
        this.testGame.pickup();
        this.testGame.setCurrentLocation(this.testGame.getBar());
        this.testGame.pickup();
        this.testGame.setCurrentLocation(this.testGame.getLibrary());
        this.testGame.shrink();
        this.testGame.pickup();
        Assert.assertEquals("Should be three", 3, this.testGame.getArrayListItemsSize());
    }
    
    @Test
    public void testDropShouldLeaveRoomWithPicture(){
        this.testGame.setCurrentLocation(this.testGame.getBar());
        this.testGame.pickup();
        this.testGame.move("east");
        this.testGame.drop("picture");
        Room room = this.testGame.getCurrentLocation();
        Item item = room.getItem();
        Assert.assertEquals("Should be Item picture", this.testGame.getPicture(), item);
    }
    
    @Test
    public void testSpinShouldSayOneDreamDeep(){
        this.testGame.setCurrentLocation(this.testGame.getLobby());
        this.testGame.pickup();
        this.testGame.setCurrentLocation(this.testGame.getBar());
        this.testGame.spin("ring");
        Assert.assertEquals("Should be one dream deep", "You are one dream deep", 
        this.testGame.getMessage());
    }
    
    @Test
    public void testHypnotizeShouldSayYouHypnotizedTheMan(){
        this.testGame.setCurrentLocation(this.testGame.getBathroom());
        this.testGame.pickup();
        this.testGame.eat("medicine");
        this.testGame.setCurrentLocation(this.testGame.getLibrary());
        this.testGame.shrink();
        this.testGame.pickup();
        this.testGame.move("sleep");
        this.testGame.hypnotize("clock");
        Assert.assertEquals("Should say you hypnotized the man", "You have successfully " +
        "hypnotized the man", this.testGame.getMessage());
    }
}