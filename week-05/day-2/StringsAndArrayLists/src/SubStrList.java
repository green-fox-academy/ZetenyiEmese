public class SubStrList {
    public static void main(String[] args) {
        String[] searchArr = {"this", "is", "search", "the", "list", "searching", "I'm", "searching", "in"};

        System.out.println(subStrList("search", searchArr)); // should print: `2`
        System.out.println(subStrList("this", searchArr)); // should print: `0`
        System.out.println(subStrList("ching", searchArr)); // should print: `5`
        System.out.println(subStrList("lis", searchArr)); // should print: `4`
    }

    public static int subStrList(String findMe, String[] searchMeArray ){
        for (int i = 0; i < searchMeArray.length; i++) {
            if (searchMeArray[i].indexOf(findMe) >= 0){
                return i; //the searched string is found in the string being at this index in the searched array
            }
        }
        return -1; //the searched string is not found
    }
}
