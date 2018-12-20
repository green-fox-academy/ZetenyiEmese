public abstract class Aircraft {

    private int ammo;

    //public Aircraft() {
    //    this.ammo = 0;
    //}

    public int getAmmo() {
        return ammo;
    }

    public abstract String getType();

    public abstract int getMaxAmmo();

    public abstract int getBaseDamage();

    public abstract boolean isPriority();

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
