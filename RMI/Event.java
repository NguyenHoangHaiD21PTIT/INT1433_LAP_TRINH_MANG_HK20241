package RMI;
import java.io.Serializable;
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode;
    private int expectedAttendance;
    public Event(){};
    public Event(String id, String eventName, String eventDate, int expectedAttendance){
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getExpectedAttendance() {
        return expectedAttendance;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventCode=" + eventCode + ", expectedAttendance=" + expectedAttendance + '}';
    }
}
