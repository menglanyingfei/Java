package test;



/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
/*
class A {
    double f(double x, double y) {
        return x + y;
    }
    static int g(int n) {
        return n * n;
    }
}

class B extends A {
    double f(double x, double y) {
        double m = super.f(x, y);
        return m + x * y;
    }
    static int g(int n) {
        int m = A.g(n);
        return m + n;
    }
}

public class Test {
    public static void main(String[] args) {
        A a = new B( );
        System.out.println(a.f(10.0, 8.0));
        //System.out.println(a.g(3));
        System.out.println(A.g(3));
    }
} 

public class Test {
	private int i = f(); 
	private int j = 10;
	private int f() {
	    return j;
	}
	public static void main(String args[]) { 
	    System.out.println((new Test()).i); 
	}
}


class Value {
    int i;
    public boolean equals(Value v) {
        return v.i == i;
    }
}
public class Test {
    public static void main(String[] args) {
        HashSet<Value> set = new HashSet<Value>();
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 39;
        set.add(v1);
        set.add(v2);
        System.out.println(set.size());
        
        int anar[]=new int[5];
        System.out.println(anar[0]);
    }
}


public class Test {
    String s;
    static class Inner {
        void testMethod() {
            s = "Hello world.";
        }
    }
    public static void main(String[] argv) {
        Inner i = new Inner();
        i.testMethod();
        System.out.println(s);
    }
}
*/

/*
public class Test {
    Package f(int port) {
        return new Package(port) {
            private int pt = port;
            public int getPort() { return pt; }
        };    
    }
}
*/

public class Test {
    public int t=4;
    public static void main(String[] args) {
        new Test().NumberPlay();
    }
    public void NumberPlay() {
        int t = 2;
        t = t+5;
        this.t = this.t-2;
        t = t-this.t;
        System.out.println(t + this.t +"ok");
        
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
    }
}












