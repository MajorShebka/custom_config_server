package com.home.dev.config_server.mapping.JpaToDomain;

import com.home.dev.config_server.service.model.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PropertyMapper {

    Property map(com.home.dev.config_server.repository.model.Property source);

    List<Property> mapAll(List<com.home.dev.config_server.repository.model.Property> source);
}
