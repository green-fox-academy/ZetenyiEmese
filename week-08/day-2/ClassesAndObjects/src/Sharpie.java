public class Sharpie {
    private String color;
    private float width;
    private float inkAmount;

    public Sharpie(String color, float width) {
        this.color = color;
        this.width = width;
        this.inkAmount = 100f;
    }

    public void use(){
        inkAmount--;
    }

    @Override
    public String toString() {
        return "Sharpie{" +
                "color='" + color + '\'' +
                ", width=" + width +
                ", inkAmount=" + inkAmount +
                '}';
    }

    public static void main(String[] args) {
        Sharpie sharpie = new Sharpie("red", 0.5f);
        System.out.println(sharpie);

        for (int i = 0; i < 5; i++) {
            sharpie.use();
        }
        System.out.println(sharpie.toString());
    }
}