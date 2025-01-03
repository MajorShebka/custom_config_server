package com.home.dev.config_server.service;

import com.home.dev.config_server.aspect.KafkaSend;
import com.home.dev.config_server.mapping.JpaToDomain.PropertyMapper;
import com.home.dev.config_server.mapping.domainToJpa.JpaPropertyMapper;
import com.home.dev.config_server.repository.service.PropertyRepositoryService;
import com.home.dev.config_server.service.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepositoryService propertyRepositoryService;

    @KafkaSend
    public void create(Property property) {
        propertyRepositoryService.save(getMapper(JpaPropertyMapper.class).map(property));
    }

    public List<Property> find(String serviceName) {
        return getMapper(PropertyMapper.class).mapAll(propertyRepositoryService.findByApplicationName(serviceName));
    }

    @KafkaSend
    public void update(Property property) {
        propertyRepositoryService.update(getMapper(JpaPropertyMapper.class).map(property));
    }
}
