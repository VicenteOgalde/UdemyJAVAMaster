package cl.vicoga.appInvoice.model;

public class ItemInvoice {

    private int amount;
    private Product product;

    public ItemInvoice(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public double totalAmount(){
        return this.amount*product.getPrice();
    }
}
