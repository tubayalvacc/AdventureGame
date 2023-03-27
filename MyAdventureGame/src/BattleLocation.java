import java.util.Random;

public class BattleLocation extends Location {
    private Monsters monsters;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monsters monsters, String award, int maxMonster){
        super(player, name);
        this.monsters = monsters;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation(){
        int monsterNo = this.randomMonsterNumber();
        System.out.println("You are Here RİGHT NOW! " + this.getName());
        System.out.println("Be Careful " + monsterNo + " " + this.getMonsters().getName() + " living here..!!!");
        System.out.print("<F>ight or <R>un ::  ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F") && combat(monsterNo)){
                System.out.println(this.getName() + "  won all the enemies!!");
                return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You are DEATH!!");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNo){
        int healing = this.getMonsters().getHealth();
        for (int i = 1; i <= monsterNo; i++){
            int firstHeat = firstHeat();
            this.getMonsters().setHealth(this.getMonsters().getOriginalHealth());
            playerStatus();
            monsterStatus(i);

            while(this.getPlayer().getHealth() > 0 && this.getMonsters().getHealth() >0) {
                System.out.print("<H> eat OR <R> un: ");
                String selectCombat = input.nextLine().toUpperCase();
                while(!selectCombat.equals("H") && !selectCombat.equals("R")){
                    System.out.println("Wrong Input! Try Again!");
                    selectCombat = input.nextLine().toUpperCase();
                }

                if (selectCombat.equals("H")) {
                    if(firstHeat == 0){
                        System.out.println("You Heat!!!");
                        this.getMonsters().setHealth((this.monsters.getHealth() - this.getPlayer().getTotalDamage()));
                        afterHeat();

                    }
                if (this.getMonsters().getHealth() > 0) {
                    System.out.println(" ");
                    System.out.println("Monster Heat You!");
                    int monsterDamage = this.getMonsters().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

                    if (monsterDamage < 0) {
                        monsterDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterHeat();
                }
                } else {
                    return false;
                }
            }
            if (this.getMonsters().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You Destroyed The Enemy!!");
                System.out.println(this.getMonsters().getAward() + " Won Money.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonsters().getAward());
                System.out.println("Your Recent Money Amount: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }
    public void afterHeat(){
        System.out.println("Your Life: " + this.getPlayer().getHealth());
        System.out.println(this.getMonsters().getName() + " Life: " + this.getMonsters().getHealth());
        System.out.println(" ");
    }
    public void playerStatus(){
        System.out.println("\t\t\t\t\tPlayer Status:  ->");
        System.out.println("<><><><><><><><><><><><><><><><>");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Defense: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
    }

    public void monsterStatus(int i){
        System.out.println("\t\t\t\t\t" + i + "." + this.getMonsters().getName() + "Monster Status:  ->");
        System.out.println("<><><><><><><><><><><><><><><><>");
        System.out.println("Health: " + this.getMonsters().getHealth());
        System.out.println("Damage: " + this.getMonsters().getDamage());
        System.out.println("Award: " + this.getMonsters().getAward());
    }
    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }
    public int firstHeat(){
        Random r = new Random();
        return r.nextInt(2);
    }
    public int getMaxMonster(){
        return maxMonster;
    }
    public void setMaxMonster(){
        this.maxMonster = maxMonster;
    }
    public Monsters getMonsters(){
        return monsters;
    }
    public void setMonsters(Monsters monsters){
        this.monsters = monsters;
    }
    public String getAward(){
        return award;
    }
    public void setAward(String award){
        this.award = award;
    }
}
