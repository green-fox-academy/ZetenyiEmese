import java.util.ArrayList;

public class SharpieSet {
    private ArrayList<Sharpie> sharpies;

    public SharpieSet() {
        sharpies = initializeSharpies();
    }

    public ArrayList<Sharpie> initializeSharpies() {
        ArrayList<Sharpie> sharpies = new ArrayList<>();

        sharpies.add(new Sharpie("red", 0.5f));
        sharpies.add(new Sharpie("green", 0.7f));
        sharpies.add(new Sharpie("blue", 0.5f));
        sharpies.add(new Sharpie("blue", 0.7f));
        sharpies.add(new Sharpie("black", 0.5f));

        return sharpies;
    }

    public void add(Sharpie sharpie){
        sharpies.add(sharpie);
    }

    public void useSharpies() {
        for (Sharpie sharpie : sharpies) {
            sharpie.use();
        }
    }

    public void useSharpie(Sharpie sharpie) {
        while (sharpie.getInkAmount() > 0) {
            sharpie.use();
        }
    }

    public int countUsable() {
        int count = 0;
        for (Sharpie sharpie : sharpies) {
            if (sharpie.getInkAmount() > 0) {
                count++;
            }
        }
        return count;
    }

    //This doesn't work:
    //public void removeTrash(){
    //    for (Sharpie sharpie : sharpies) {
    //        if (sharpie.getInkAmount() == 0) {
    //            sharpies.remove(sharpie);
    //        }
    //    }
    //}

    public void removeTrash(){
        for (int i = 0; i < sharpies.size(); i++) {
            if (sharpies.get(i).getInkAmount() <= 0){
                sharpies.remove(i);
                i--;
            }
        }
    }

    @Override
    public String toString() {
        return "SharpieSet{" +
                "sharpies=" + sharpies +
                '}';
    }
}
