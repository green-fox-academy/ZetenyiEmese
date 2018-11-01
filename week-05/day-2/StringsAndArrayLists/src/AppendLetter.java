import java.util.Arrays;
import java.util.List;

public class AppendLetter {
    public static void main(String[] args) {
        List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
        System.out.println(appendA(far));
        System.out.println(far); //the original list is changed
    }

    //IGY NEM MŰKÖDIK! A lista változatlan marad: az elemeihez nem adódnak hozzá az "a" betűk!
    //public static List<String> appendA(List<String> list){
    //    for (String str: list) {
    //        str += "a";
    //    }
    //    return list;
    //}

    public static List<String> appendA(List<String> list){
        for (int i = 0; i < list.size(); i++){
           list.set(i, list.get(i) + "a");
        }
        return list;
    }
 }
