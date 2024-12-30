package com.home.dev.config_server.mapping.domainToApi;

import com.home.dev.config_server.api.model.PropertyApi;
import com.home.dev.config_server.service.model.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PropertyApiMapper {

    PropertyApi map(Property property);

    List<PropertyApi> map(List<Property> properties);
}
