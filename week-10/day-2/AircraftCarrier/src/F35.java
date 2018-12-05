public class F35 extends Aircraft {

    private static String type = "F35";
    private static int maxAmmo = 12;
    private static int baseDamage = 50;
    private static boolean priority = true;

    public F35() {
        super();
    }

    public static String getType() {
        return type;
    }

    @Override
    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    public static boolean isPriority() {
        return priority;
    }

    public String getStatus() {
        int allDamage = getAmmo() * baseDamage;
        return "Type: " + type + ", Ammo: " + getAmmo() + ", Base Damage: " + baseDamage + ", All Damage: " + allDamage;
    }

}
