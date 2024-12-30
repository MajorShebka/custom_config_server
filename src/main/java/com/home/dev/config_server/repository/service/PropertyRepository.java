package com.home.dev.config_server.repository.service;

import com.home.dev.config_server.repository.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByServiceName(String serviceName);
}
