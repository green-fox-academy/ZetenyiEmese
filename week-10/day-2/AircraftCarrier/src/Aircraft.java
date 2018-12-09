public class Aircraft {

    private static String type;
    private static int maxAmmo;
    private static int baseDamage;
    private static boolean priority;
    private int ammo;

    public Aircraft() {
        this.ammo = 0;
    }

    //in order to reach the static field type in the subclass with dynamic binding
    public String getType() {
        return type;
    }

    //in order to reach the static field maxAmmo in the subclass with dynamic binding
    public int getMaxAmmo() {
        return maxAmmo;
    }

    //in order to reach the static field baseDamage in the subclass with dynamic binding
    public int getBaseDamage() {
        return baseDamage;
    }

    //in order to reach the static field priority in the subclass with dynamic binding
    public boolean isPriority() {
        return priority;
    }

    public int getAmmo() {
        return ammo;
    }

    public int fight() {
        int damage = ammo * getBaseDamage();
        ammo = 0;
        return damage;
    }

    public int refill(int ammoAmount) {
        int ammoNeed = getMaxAmmo() - ammo;
        if (ammoNeed > 0){
            boolean isEnough = ammoAmount > ammoNeed;
            if (isEnough) {
                ammo += ammoNeed;
                return ammoAmount - ammoNeed;
            } else {
                ammo += ammoAmount;
                return 0;
            }
        } else {
            return ammoAmount;
        }
    }

    public String getStatus() {
        int allDamage = ammo * getBaseDamage();
        return "Type: " + getType() + ", Ammo: " + ammo + ", Base Damage: " + getBaseDamage() + ", All Damage: " + allDamage;
    }

}
