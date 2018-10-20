import java.util.Scanner;
public class SubStr {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);

        System.out.println("Enter the text that you want to search in:");
        String searchMeText = textInput.nextLine();

        System.out.println("Enter the text that you want to find:");
        String findMeText = textInput.nextLine();

        System.out.println(subStr(searchMeText, findMeText));
    }

    public static int subStr(String searchMe, String findMe) {
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();

        boolean foundIt = false;
        int i;

        for (i = 0; i <= searchMeLength-findMeLength; i++){
            foundIt = searchMe.regionMatches(i, findMe, 0, findMeLength);
            if (foundIt){
               break;
            }
        }

        if (foundIt) {
            return i;
        } else {
            return -1;
        }
    }
}
