package mk.ecode.events.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    String name;
    String description;
    double popularityScore;

    public Event(String name, String description, double popularityScore) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
    }
}
