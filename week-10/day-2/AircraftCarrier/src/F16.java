public class F16 extends Aircraft {

    private static String type = "F16";
    private static int maxAmmo = 8;
    private static int baseDamage = 30;
    private static boolean priority = false;

    public F16() {
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
