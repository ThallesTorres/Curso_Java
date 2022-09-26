package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private static DateTimeFormatter dateHourFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDateTime moment;
    
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n--ORDER SUMMARY--");
        sb.append("\nOrder moment: " + getMoment().format(dateHourFormatter));
        sb.append("\nOrder status: " + getStatus().toString());
        sb.append("\nClient: " + getClient().getName());
        sb.append(" (" + getClient().getBirthDate().format(dateFormatter) + ") - ");
        sb.append(getClient().getEmail());
        sb.append("\n-Order items-");
        for (OrderItem item : items) {
            sb.append(item.toString());
        }
        sb.append(String.format("\nTotal price: $%.2f\n", total()));

        return sb.toString();
    }
}
