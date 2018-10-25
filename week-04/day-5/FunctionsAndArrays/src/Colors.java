import java.util.Arrays;

public class Colors {
    public static void main(String[] args) {
        String[][] colors = {
                {"lime", "forest green", "olive", "pale green", "spring green"},
                {"orange red", "red", "tomato"},
                {"orchid", "violet", "pink", "hot pink"}
        };
        display(colors);
    }

    public static void display(String[][] array){
        for (String[] row: array) {
            for (String item: row) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}


