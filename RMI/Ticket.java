package RMI;
import java.io.Serializable;
public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName, saleDate, ticketCode;
    public Ticket(){}
    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
    }
    public String getEventName() {
        return eventName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}
