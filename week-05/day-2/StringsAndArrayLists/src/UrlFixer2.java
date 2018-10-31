public class UrlFixer2 {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        url = createNewUrl(url);
        System.out.println(url);
    }

    public static String createNewUrl(String url){
        String str1 = url.substring(0, 5);
        str1 = str1.concat(":");

        String str2 = url.substring(5, url.length());
        str2 = str2.replace("bots", "odds");

        return str1.concat(str2);
    }
}
