import java.util.ArrayList;

public class PracWithArraylistsGeneric {
    public static void main(String[] args) {
        // ArrayList a = new ArrayList();
        // a.add("Sally");
        // a.add("Joe");
        // a.add("Bob");

        // for (String s : a) {
        //     System.out.println(s.charAt(0));
        // }

        ArrayList<String> a = new ArrayList<String>();
        a.add("Sally");
        a.add("Joe");
        a.add("Bob");

        for (String s : a) {
            System.out.println(s.charAt(0));
        }
    }
}
