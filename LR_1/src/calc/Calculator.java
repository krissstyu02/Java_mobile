package calc;
     
import calc.operation.Adder;
import calc.operation.Multiplicator;
import calc.operation.Squaring;
import calc.operation.Divider;
import calc.operation.Subtructor;

public class Calculator
{
    public int sum(int... a)
    {
        Adder adder=new Adder();
        for(int i:a)
        {
            adder.add(i);
        }
        return adder.getSum();
    }

    public int sub(int... a)
    {
        if (a.length == 0)
        {
            return 0;
        }
        Subtructor subtructor = new Subtructor(a[0]);
        for (int i = 1; i < a.length; i++)
        {
            subtructor.subtruct(a[i]);
        }
        return subtructor.getSub();
    }

    public double div(int... a)
    {
        if (a.length == 0)
        {
            return 1;
        }
        Divider divider = new Divider(a[0]);
        for (int i = 1; i < a.length; i++)
        {
            divider.divv(a[i]);
        }
        return divider.getDiv();
    }

    public int mul(int... a)
    {
        Multiplicator multiplicator = new Multiplicator(a[0]);
        for (int i = 1; i < a.length; i++)
        {
            multiplicator.multiplicate(a[i]);
        }
        return multiplicator.getMul();
    }

    public int squar(int... a)
    {
        Squaring squaring= new Squaring(a[0]);
        return squaring.getSquaring();
    }

}