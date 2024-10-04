public class Milk implements ICondiment {


    @Override
    public String addCondiment() {
        return "Milk added\n";
    }

    @Override
    public double getCost() {
        return 2;
    }
}
