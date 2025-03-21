import java.util.Comparator;

class EventComp implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        if (e1.eventTime() < e2.eventTime()) {
            return -1;
        } else if (e1.eventTime() > e2.eventTime()) {
            return 1;
        } else {
            if (e1.getCustomer().startTime() < e2.getCustomer().startTime()) {
                return -1;
            } else if (e1.getCustomer().startTime() > e2.getCustomer().startTime()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

