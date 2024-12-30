package com.home.dev.config_server.mapping.apiToDomain;

import com.home.dev.config_server.api.model.PropertyApi;
import com.home.dev.config_server.service.model.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PropertyMapper {

    Property map(PropertyApi source);

    List<Property> map(List<PropertyApi> source);
}
