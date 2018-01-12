package tij4;

import static tij4.Utils.*;

class Insect {

    private int i = 9;
    
    {
        print("Insect non-static code block");
    }
    
    protected int j = printInit("Insetc.j initialized");
    
    Insect() {
       print("i = " + i + ", j = " + j);
       j = 39;
    }
    
    private static int x1 = printInit("static Insect.x1 initialized");
    
    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {

    private int k = printInit("Beetle.k initialized");
    
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    
    {
        print("Beetle non-static code block");
    }

    private static int x2 = printInit("static Beetle.x2 initialized");
    
    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}
