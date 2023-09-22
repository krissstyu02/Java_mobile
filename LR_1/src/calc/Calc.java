package calc;
import calc.Calculator;

public class Calc {

public static void main(String[] args) {
          Calculator calc=new Calculator(); 
          System.out.println("1+2+3="+calc.sum(1,2,3));
          System.out.println("5-2-1="+calc.sub(5,2,1));
          System.out.println("5*2*3="+calc.mul(5,2,3));
          System.out.println("20/2/5="+calc.div(20,2,5));
          System.out.println("20^2="+calc.squar(20));
//          запустить архив java -jar Calc.jar
}
}