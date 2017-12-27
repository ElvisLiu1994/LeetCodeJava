import java.lang.reflect.Field;

public class Swap {
    
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    
    public static void swap(Integer a, Integer b) {
        Integer tmp = a;
        a =  b;
        b = tmp;
    }
    
    public static void swap(MyInt a, MyInt b) {
        MyInt tmp = a;
        a =  b;
        b = tmp;
    }
    
    public static void swap1(Integer i1, Integer i2) {
        try{
            // Integer类里面有个类变量private final int val;
            Field f = Integer.class.getDeclaredField("value");
            f.setAccessible(true);

            int tmp = i1.intValue();
            f.set(i1, i2.intValue());
            f.set(i2, tmp);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void add(Integer i) {
//        i++;
        i = new Integer(i+1);
        //无论上面哪做法都是将形参i指向了另外一个值为i+1的空间，而实参i的指向始终不会被
        //类似于指针传递，int* i; 如果仅仅只是将 i = &(i+1)这样的话，不会对外面的i指向产生任何影响
        //所以只能通过修*i来达到修改的目的
        //换句话说就是，形参也只是个局部变量，与实参指向同一片内存空间而以，如果只是让形参指向另一个空间，那么对实参是不会产生影响的
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.println("a = "+a+", b = "+b);
        
        Integer x = 3;
        Integer y = 4;
        swap(x,y);
        System.out.println("x = "+x+", y = "+y);
        
        Integer m = new Integer(5);
        Integer n = new Integer(6);
        swap(m,n);
        System.out.println("m = "+m+", n = "+n);
        
        MyInt k = new MyInt(7);
        MyInt t = new MyInt(8);
        swap(k,t);
        System.out.println("k = "+k+", t = "+t);
        
        //当mm与nn的值在[-128,127]时，会出错，但是当都不在这个范围内时，swap1会起作用
        Integer mm = 30;
        Integer nn = 40;
        swap1(mm, nn);
        System.out.println("mm = "+mm+", nn = "+nn);
        
        //按道理，这样写的话，mm1与nn1都不会在Integer.cache中，而是新开辟的空间，但是结果还是与上面一样
        //这是因为在swap1函数里面，tmp也发生了自动装箱和拆箱，从而导致结果出错。
        Integer mm1 = new Integer(30);
        Integer nn1 = new Integer(40);
        swap1(mm1, nn1);
        System.out.println("mm1 = "+mm1+", nn1 = "+nn1);
        
        Integer xx = 11;
        Integer yy = 11;
        Integer zz = new Integer(11);
        Integer tt = new Integer(11);
        System.out.println(xx==yy);
        System.out.println(xx==zz);
        System.out.println(zz==tt);
        
        Integer aa = 129;
        Integer bb = 129;
        Integer cc = new Integer(129);
        System.out.println(aa == cc);
        System.out.println(aa == bb);
        
        Integer i1 = new Integer(1);
        add(i1);
        System.out.println(i1); // i1仍然是1
    }

}

class MyInt{
    int val;
    public MyInt(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
