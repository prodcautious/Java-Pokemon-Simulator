public class Move
{
    private String moveName;
    private int moveDamage;
    
    // Private constants (Increased to fit realistic pokemon move damage)
    private static final int MAX_DAMAGE = 100;
    
    // Write your implementation of the Move class here
    public Move(String name, int damage)
    {
        moveName = name;
        if(damage > MAX_DAMAGE)
        {
            moveDamage = 25;
        }
        else
        {
            moveDamage = damage;  
        }

    }
    
    public String getName()
    {
        return moveName;
    }
    
    public int getDamage()
    {
        return moveDamage;   
    }
    
    public String toString()
    {
        return moveName + "(" + moveDamage + " Damage)";
    }
}