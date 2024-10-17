import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements IProduct{

    private boolean addDiscount;

    private List<IProduct> productList=new ArrayList<>();
    public void addProduct(IProduct product)
    {
        productList.add(product);
    }

    public void setAddDiscount(boolean addDiscount) {
        this.addDiscount = addDiscount;
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

        String bundleDescription="Bundle of products:\n";

        for(IProduct product:productList)
        {
            bundleDescription+=product.getDescription()+"\n";
        }

        return bundleDescription;
    }
}
