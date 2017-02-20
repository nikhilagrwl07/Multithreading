package Multithreading;

/**
 * Created by nikhilagrawal on 20/01/17.
 */
public class God {
    String name;

    public God(String name) {
        this.name = name;
    }


    public static void foo(God g){

        g = new God("P");
        g.name="hindu";
    }

    public static void goo(God g){
        g=null;
    }


    public static void main(String[] args) {
//        God g = new God("M");
//        foo(g);
//        System.out.println(g.name);
//        goo(g);
            String s1 = "God";
            String s2 = s1;
            s1="bad";
        System.out.println(s1);

        String s="Sachin";

        s=s.concat(" Tendulkar");//concat() method appends the string at the end

        System.out.println(s);//will print Sachin because strings are immutable objects

        StringBuffer str = new StringBuffer("Good");
        str.append(" Morning");
        System.out.println(str);
        str.setCharAt(0,'Z');
        System.out.println(str);
    }
}
