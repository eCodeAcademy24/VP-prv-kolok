package mk.ecode.events.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ecode.events.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> events = new ArrayList<>();

    @PostConstruct
    public void init() {
        events.add(new Event("Test 1", "Desc 1", 2.50));
        events.add(new Event("Test 2", "Desc 2", 5.50));
        events.add(new Event("Test 3", "Desc 3", 3.50));
        events.add(new Event("Test 4", "Desc 4", 1.50));
        events.add(new Event("Test 5", "Desc 5", 2.34));
        events.add(new Event("Test 6", "Desc 6", 8.55));
        events.add(new Event("Test 7", "Desc 7", 1.50));
        events.add(new Event("Test 8", "Desc 8", 2.50));
        events.add(new Event("Test 9", "Desc 9", 3.50));
        events.add(new Event("Test 10", "Desc 10", 6.50));
    }
}
