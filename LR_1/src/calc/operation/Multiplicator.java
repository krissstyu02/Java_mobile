package calc.operation;

public class Multiplicator
{
    private int mul;

    public Multiplicator()
    {
        mul = 1;
    }

    public Multiplicator(int a)
    {
        this.mul = a;
    }

    public void multiplicate(int b)
    {
        mul *= b;
    }

    public int getMul()
    {
        return mul;
    }
}