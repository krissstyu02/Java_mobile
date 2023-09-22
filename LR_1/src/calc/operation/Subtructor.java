package calc.operation;
     
public class Subtructor
{
    private int sub;

    public Subtructor()
    {
        sub=0;
    }

    public Subtructor(int a)
    {
        this.sub=a;
    }

    public void subtruct(int b)
    {
        sub-=b;
    }
        
    public int getSub()
    {
        return sub;
    }
}