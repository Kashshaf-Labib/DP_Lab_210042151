import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements IProduct{

    private String name;

    private boolean addDiscount;

    private List<IProduct> productList;
    public void addProduct(IProduct product)
    {
        productList.add(product);
    }

    public void setAddDiscount(boolean addDiscount) {
        this.addDiscount = addDiscount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double totalPrice=0;

        for(IProduct product:productList)
        {
            totalPrice+=product.getPrice();
        }

        if(addDiscount)
        {
            totalPrice=totalPrice*0.95;
        }

        return totalPrice;
    }

    @Override
    public String getDescription() {

        String bundleDescription="";

        for(IProduct product:productList)
        {
            bundleDescription+=product.getName()+" "+product.getDescription()+"\n";
        }

        return bundleDescription;
    }

    public ProductBundle(String name, boolean addDiscount) {
        this.name = name;
        this.addDiscount = addDiscount;
        productList=new ArrayList<>();
    }
}
