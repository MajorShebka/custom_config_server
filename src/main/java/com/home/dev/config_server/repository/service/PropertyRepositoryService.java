package com.home.dev.config_server.repository.service;

import com.home.dev.config_server.repository.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyRepositoryService {

    private final PropertyRepository propertyRepository;

    public void save(Property property) {
        propertyRepository.save(property);
    }

    public List<Property> findByApplicationName(String serviceName) {
        return propertyRepository.findByServiceName(serviceName);
    }
}
