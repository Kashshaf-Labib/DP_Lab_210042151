import java.util.Dictionary;
import java.util.Hashtable;

public class BeverageAdder {

    public static Dictionary<Integer,IBeverage>prepareBeverage()
    {
        Dictionary<Integer,IBeverage> beverages = new Hashtable<Integer,IBeverage>();
        beverages.put(1,new Coffee());
        beverages.put(2,new Espresso());
        beverages.put(3,new Latte());
        return beverages;
    }

}
