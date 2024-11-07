package mk.ecode.events.service;

import mk.ecode.events.model.Event;

import java.util.List;

public interface EventService {

    List<Event> listAll();

    List<Event> searchEvents(String text);

    List<Event> filter(String searchText, String popularityScore);
}
