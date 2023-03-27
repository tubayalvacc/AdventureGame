public class ToolStore extends NormalLocation {
    public ToolStore (Player player){
        super (player, "Tool Store");
    }

    @Override
    public boolean onLocation () {
        System.out.println("Welcome to The Tool Store !");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 ->\tGuns");
            System.out.println("2 -> \tArmors");
            System.out.println("3 -> \tQuit");
            System.out.println(" ");
            System.out.print("Your Choice: ");
            int selectTools = input.nextInt();

            while (selectTools < 1 || selectTools > 3) {
                System.out.println("Invalid Input. Please Try Again.");
                selectTools = input.nextInt();
            }
            switch (selectTools){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See You Later Soon !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println(" ");
        System.out.println("\t\t\t\t^-^   G U N S   ^-^");
        System.out.println(" ");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + "\tWeapon Name: " + w.getName() + "\t<<< Price: " + w.getPrice() + "\tDamage: " + w.getDamage() + " >>>");
        }
        System.out.println("0 - Quit !");
    }
    public void buyWeapon() {
        System.out.println(" ");
        System.out.print("Choose Your Gun to Continue ->  ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid Input. Please Try Again.");
            selectWeaponID = input.nextInt();
            }

        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Don't have enough money");
                } else {
                    //Weapon Buying System
                    System.out.println(selectedWeapon.getName() + " Bought The Weapon !");
                    int newBalance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(newBalance);
                    System.out.println("Remaining Money: " + this.getPlayer().getMoney());
                    System.out.println("The Gun you used before buying ->"+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new Weapon -> "+this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("<><><><><><><><><><><><><><><><><><><><>");
                }
            }
        }



    }
    public void printArmor(){
        System.out.println(" ");
        System.out.println("\t\t\t\t^-^   A R M O R S   ^-^");
        System.out.println(" ");
        for (Armor arm : Armor.armors()) {
            System.out.println("ID: " + arm.getId() + "\t\tWeapon Name: " + arm.getName() + "\t\t<<< Price: " + arm.getPrice() + "\t\tBlock: " + arm.getBlock() + " >>>");
        }
        System.out.println("0 - Quit !");

    }

    public void buyArmor(){
        System.out.println(" ");
        System.out.print("Choose Your Armor to Continue ->  ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid input. Please Try Again !");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjectByID(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Don't have enough money !");
                } else {
                    //Armor Buying System
                    System.out.println(selectedArmor.getName() + " Bought The Armor ! \t");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    //int newBalance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    //this.getPlayer().setMoney(newBalance);
                    System.out.println("Remaining Money After Armor Purchase ->  " + this.getPlayer().getMoney());

                    System.out.println("The Armor You Purchased ->  " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new Armor ->  " + this.getPlayer().getInventory().getArmor().getName());
                    System.out.println("<><><><><><><><><><><><><><><><><><><><>");
                }
            }
        }
    }
}
