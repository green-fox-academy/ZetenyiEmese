public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        url = createNewUrl(url);
        System.out.println(url);
    }

    public static String createNewUrl(String url){
        String newUrl = url.replace("https", "https:").replace("bots", "odds");
        return newUrl;
    }
}
