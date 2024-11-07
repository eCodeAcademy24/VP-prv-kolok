package mk.ecode.events.service.impl;

import mk.ecode.events.model.Event;
import mk.ecode.events.repository.EventRepository;
import mk.ecode.events.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.listAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        if (text.startsWith(" ") || text.startsWith(",") || text.startsWith(".")
                || text.startsWith("!") || text.startsWith("?")) {
            text = text.substring(1);
        } else if (text.endsWith(" ") || text.endsWith(",") || text.endsWith(".")
                || text.endsWith("!") || text.endsWith("?")) {
            text = text.substring(0, text.length() - 1);
        }

        return eventRepository.searchEvents(text);
    }

    @Override
    public List<Event> filter(String searchText, String popularityScore) {
        if (!searchText.isEmpty() && !popularityScore.isEmpty()) {
            return eventRepository.findByNameContainingAndPopularityScoreGreaterThanEqual(searchText, Double.valueOf(popularityScore));
        } else if (!searchText.isEmpty()) {
            return eventRepository.findByNameContaining(searchText);
        } else if (!popularityScore.isEmpty()) {
            return eventRepository.findByPopularityScoreGreaterThanEqual(Double.valueOf(popularityScore));
        }

        return listAll();
    }
}
