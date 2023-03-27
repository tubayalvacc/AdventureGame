import java.util.Scanner;
public class Game {
    private Scanner input = new Scanner(System.in);
    String player;
    String location;

    public void start(){
        System.out.println("Welcome to The Adventure Game!");
        System.out.print("Please Enter Name: ");
        //String playerName = input.nextLine();
        Player player = new Player("tubamhd");
        System.out.println("Miss./Mrs. " + player.getName() + " Welcome to The Deep Dark Island! Whatever Happens here is R E A L!!");
        System.out.println(" ");
        System.out.print("Please Choose Character ->  ");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println("\t\t\t\t^-^  L O C A T I O N S  ^-^");
            System.out.println("0-End The Game. ");
            System.out.println("1-Safe House ! - << Award: Life Renewal >> - This is the most safest place for you. No enemies detected !");
            System.out.println("2-Tool Store ! - You Can Buy Guns or Armor. ");
            System.out.println("3-Cave ! - << Award: Food >> - Enter to the Cave. Be Careful. Monster might come anytime !!!");
            System.out.println("4-Forest ! - << Award: FireWood >> - Heeyy!! Vampire is able to hear youu...");
            System.out.println("5-River ! - << Award: Water >> - Ooopss! Bear ran away from his CAVE.. It might be around...!!!");
            System.out.println("6-Quarry ! - <<Award: Trophy >> - OOMMGG! Lots of Snakes are around. Be very careful!!...");
            System.out.print("Choose the Location Where You Want to Go -> -> ");
            int selectLocation = input.nextInt();
            boolean isPassLocation = true;

            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().getFood().equals("Food")) {
                        System.out.println("You Have Already Passed The Level and Won The " + player.getInventory().getFood() + " Prize! You Can not Enter Again!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Cave(player);
                    break;
                case 4:
                    if (player.getInventory().getFirewood().equals("Firewood")) {
                        System.out.println("You Have Already Passed The Level and Won The " + player.getInventory().getFirewood() + " Prize! You Can not Enter Again!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Forest(player);
                    break;
                case 5:
                    if (player.getInventory().getWater().equals("Water")) {
                        System.out.println("You Have Already Passed The Level and Won The " + player.getInventory().getWater() + " Prize! You Can not Enter Again!");
                        isPassLocation = false;
                        break;
                    }
                    location = new River(player);
                    break;
                case 6:
                    if (player.getInventory().getSnake().equals("Trophy")) {
                        System.out.println("You Have Passed The Section Already! You Can Not Enter Again.");
                        isPassLocation = false;
                        break;
                    }
                    location = new Quarry(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (location == null){
                System.out.println("You Gave Up from This Scary Island! Game Over! See You Again!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }


    }
}
