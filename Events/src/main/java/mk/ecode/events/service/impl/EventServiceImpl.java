package mk.ecode.events.service.impl;

import mk.ecode.events.model.Event;
import mk.ecode.events.model.Location;
import mk.ecode.events.repository.EventRepository;
import mk.ecode.events.service.EventService;
import mk.ecode.events.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationService locationService;

    public EventServiceImpl(EventRepository eventRepository, LocationService locationService) {
        this.eventRepository = eventRepository;
        this.locationService = locationService;
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

    @Override
    public void saveEvent(String name, String description, Double popularityScore, Long locationId) {
        Location location = locationService.findById(locationId);
        eventRepository.saveEvent(name, description, popularityScore, location);
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public void editEvent(Long id, String name, String description, Double popularityScore, Long locationId) {
        Location location = locationService.findById(locationId);
        eventRepository.editEvent(id, name, description, popularityScore, location);
    }

    @Override
    public void delete(Long id) {
        eventRepository.delete(id);
    }
}
