public class SafeHouse extends NormalLocation{
    public SafeHouse (Player player){
        super (player, "SafeHouse");
    }

    @Override
    public boolean onLocation() {
        System.out.println("WELCOME!");
        System.out.println("You are at Safe House !  :)");
        System.out.println("Your Life Renewed !");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
