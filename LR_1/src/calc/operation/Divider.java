package calc.operation;

public class Divider
{
    private double div;

    public Divider()
    {
        div = 1;
    }

    public Divider(int a)
    {
        this.div = a;
    }

    public void divv(int b)
    {
        if (b != 0)
        {
            div /= b;
        }
    }

    public double getDiv()
    {
        return div;
    }
}