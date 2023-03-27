public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String food;
    private String water;
    private String firewood;
    private String snake;

    public Inventory(){
        this.weapon = new Weapon("Punch", -1, 0, 0);
        this.armor = new Armor(-1, "Unarmored", 0, 0);
        this.food = "";
        this.water = "";
        this.firewood = "";
        this.snake = "";
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public Armor getArmor(){
        return armor;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public String getFood(){
        return food;
    }
    public void setFood(java.lang.String food) {
        this.food = food;
    }
    public String getWater(){
        return water;
    }
    public void setWater(String water){
        this.water = water;
    }
    public String getFirewood(){
        return firewood;
    }
    public void setFirewood(String firewood){
        this.firewood = firewood;
    }
    public String getSnake(){
        return snake;
    }
    public void setSnake(String snake){
        this.snake = snake;
    }
}
