package test;
/**
 * @author menglanyingfei
 * @date 2017-8-16
 */
class Base0 {
    Base0(int i){
        System.out.println("base0 constructor");
    }
    Base0(){}
}
public class BaseSup extends Base0 {
    public static void main(String argv[]){
        //BaseSup s= new BaseSup();
        //One
        //super(10);
    }
    BaseSup(){
    	super(10);
        //Two
    }
    public void derived(){
        //Three
    }
}
