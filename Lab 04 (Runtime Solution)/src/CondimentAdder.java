import java.util.Dictionary;
import java.util.Hashtable;

public class CondimentAdder {

    public static Dictionary<Integer,ICondiment>addCondiment()
    {
        Dictionary<Integer,ICondiment> condiments = new Hashtable<Integer,ICondiment>();
        condiments.put(1,new WhiteSugar());
        condiments.put(2,new Milk());
        condiments.put(3,new WhippedCream());
        return condiments;
    }
}
