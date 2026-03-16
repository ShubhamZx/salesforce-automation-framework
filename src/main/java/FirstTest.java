import java.util.ArrayList;

public class FirstTest {
    public static void main(String[] args) {

        ArrayList<String> browsers = new ArrayList<>();
        browsers.add("Chrome");
        browsers.add("Firefox");
        browsers.add("Safari");

        for (String b: browsers){
            System.out.println(b);
        }

        browsers.remove("Firefox");
        System.out.println(browsers.size());
    }
}