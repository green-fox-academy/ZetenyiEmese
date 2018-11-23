public class SharpieSetMain {
    public static void main(String[] args) {
        SharpieSet sharpieSet = new SharpieSet();
        System.out.println(sharpieSet);

        sharpieSet.useSharpies();
        System.out.println(sharpieSet);

        System.out.println("There are " + sharpieSet.countUsable() + " usable sharpies.");
        System.out.println();

        Sharpie newSharpie = new Sharpie("black", 0.7f);
        sharpieSet.add(newSharpie);
        System.out.println(sharpieSet);
        System.out.println("There are " + sharpieSet.countUsable() + " usable sharpies.");
        System.out.println();

        sharpieSet.useSharpie(newSharpie);
        System.out.println(sharpieSet);

        System.out.println("There are " + sharpieSet.countUsable() + " usable sharpies.");
        System.out.println();

        sharpieSet.removeTrash();
        System.out.println(sharpieSet);
        System.out.println("There are " + sharpieSet.countUsable() + " usable sharpies.");
    }
}