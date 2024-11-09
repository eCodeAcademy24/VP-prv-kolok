package mk.ecode.events.service.impl;

import mk.ecode.events.model.Location;
import mk.ecode.events.repository.LocationRepository;
import mk.ecode.events.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow();
    }
}
