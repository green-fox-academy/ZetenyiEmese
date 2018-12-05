public class Aircraft {

    private static int maxAmmo;
    private static int baseDamage;
    private int ammo;

    public Aircraft() {
        this.ammo = 0;
    }

    public int getAmmo() {
        return ammo;
    }

    //in order to reach the static field maxAmmo in the subclass with dynamic binding
    public int getMaxAmmo() {
        return maxAmmo;
    }

    //in order to reach the static field baseDamage in the subclass with dynamic binding
    public int getBaseDamage() {
        return baseDamage;
    }

    public int fight() {
        int damage = ammo * getBaseDamage();
        ammo = 0;
        return damage;
    }

    public int refill(int ammoAmount) {
        if (ammo < getMaxAmmo()){
            boolean isEnough = ammoAmount > getMaxAmmo() - ammo;
            if (isEnough) {
                ammo = getMaxAmmo();
                return ammoAmount - (getMaxAmmo() - ammo);
            } else {
                ammo += ammoAmount;
                return 0;
            }
        } else {
            return ammoAmount;
        }
    }

}
