public class EPostalMailAdapter implements INotification{

    private EPostalMailNotification epmn;

    private String address;

    public EPostalMailAdapter(EPostalMailNotification epmn,String address){
        this.epmn=epmn;
        this.address=address;
    }

    @Override
    public void sendNotification(String message) {
        epmn.sendNotification(message,address);
    }
}
