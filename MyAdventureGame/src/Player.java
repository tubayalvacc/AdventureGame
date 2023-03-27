import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    //Created Constructor Method
    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){
        //Samurai samurai = new Samurai();
        //Knight knight = new Knight();
        //Archer archer = new Archer();

        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};

        for (GameCharacter gameCharacter : charList) {
            System.out.println("Character: \n\t->\t"+gameCharacter.getName() +
                    "\tID: "+gameCharacter.getId()+"\tDamage: "+gameCharacter.getDamage()+
                    "\tHealth: "+gameCharacter.getHealth()+"\tMoney: "+gameCharacter.getMoney());
        }
        System.out.println(" ");
        System.out.print("Please Choose a Character ->");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        //System.out.println(">>>>>>>>>>>>>>>>>\tCongratulations!! You are a " +this.getCharName()+ "\t<<<<<<<<<<<<<<<<<<<<<<" +
                //"\n\t\t\tYour Character: "+ this.getCharName() +
                //"\nFeatures -> -> Damage: "+ this.getDamage() +"\tHealth: "+this.getHealth() +"\tMoney: "+this.getMoney());
        System.out.println(" ");
    }


    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public void printInfo(){
        System.out.println(
                "Congratulations !! You are a " + this.getCharName()+
                        "\n\t\t\tYour Gun: " + this.getInventory().getWeapon().getName() +
                "\t\tYour Armor: " + this.getInventory().getArmor().getName() +
                "\t\tArmor-Defense: " + this.getInventory().getArmor().getBlock() +
                "\t\tYour Damage: " + this.getTotalDamage() +
                "\t\tYour Health: " + this.getHealth() +
                "\t\tYour Money: " + this.getMoney());
        System.out.println(" ");
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public String getCharName(){
        return charName;
    }
    public void setCharName(String charName){
        this.charName = charName;
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        //this method is used for calling weapon name more shortly. Instead of calling from Inventory class we can use by player class.
        return this.getInventory().getWeapon();
    }
    public int getOriginalHealth(){
        return originalHealth;
    }
    public void setOriginalHealth(int originalHealth){
        this.originalHealth = originalHealth;
    }


}
