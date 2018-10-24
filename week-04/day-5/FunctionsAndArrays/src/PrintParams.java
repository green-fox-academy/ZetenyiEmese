public class PrintParams {
    public static void main(String[] args) {
        printParams("first");
        printParams("first", "second");
        printParams("first", "second", "third", "fourth");
        printParams("rose", "tulip", "daisy", "daffodil", "lily", "lavender", "orchid");
    }    

    public static void printParams(String...strings){
        for (String str: strings ) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}
