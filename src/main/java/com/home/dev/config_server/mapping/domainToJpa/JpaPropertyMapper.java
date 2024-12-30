package com.home.dev.config_server.mapping.domainToJpa;

import com.home.dev.config_server.repository.model.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface JpaPropertyMapper {

    Property map(com.home.dev.config_server.service.model.Property source);

    List<Property> mapAll(List<com.home.dev.config_server.service.model.Property> source);
}
