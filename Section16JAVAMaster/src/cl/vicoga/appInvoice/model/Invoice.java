package cl.vicoga.appInvoice.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int id;
    private static int lastId;
    private String description;
    private Date date;
    private Client client;
    private ItemInvoice[] items;
    private int indexItems;
    public static final int MAX_ITEMS = 10;


    public Invoice(String description, Client client) {
        this.description = description;
        this.client = client;
        this.items = new ItemInvoice[MAX_ITEMS];
        this.id = ++lastId;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ItemInvoice[] getItems() {
        return items;
    }

    public void addItem(ItemInvoice item) {
        if (indexItems < MAX_ITEMS) {
            this.items[indexItems++] = item;
        }
    }

    public double totalInvoice() {
        double total = 0;
        for (ItemInvoice item : this.items) {

            total += (item != null) ? item.totalAmount() : 0;
        }
        return total;
    }

    public String generateDescription() {
        StringBuilder sb = new StringBuilder("Invoice n°");
        SimpleDateFormat sd= new SimpleDateFormat("dd 'of' MMMM, yyyy");

        sb.append(id)
                .append("\nClient: ")
                .append(client.getName())
                .append("\trut: ")
                .append(client.getRut())
                .append("\nDate: ").append(sd.format(this.getDate()))
                .append("\nDescription: ")
                .append(this.getDescription())
                .append("\nTotal: ")
                .append(this.totalInvoice())
        ;
        return sb.toString();


    }
}
