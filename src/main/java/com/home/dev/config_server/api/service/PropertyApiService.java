package com.home.dev.config_server.api.service;

import com.home.dev.config_server.api.message.PropertyRequest;
import com.home.dev.config_server.api.message.PropertyResponse;
import com.home.dev.config_server.api.model.PropertyApi;
import com.home.dev.config_server.mapping.apiToDomain.PropertyMapper;
import com.home.dev.config_server.mapping.domainToApi.PropertyApiMapper;
import com.home.dev.config_server.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyApiService {

    private final PropertyService propertyService;

    @GetMapping("/{serviceName}")
    public PropertyResponse getProperties(@PathVariable String serviceName) {
        List<PropertyApi> map = getMapper(PropertyApiMapper.class).map(propertyService.find(serviceName));
        return new PropertyResponse(map);
    }

    @PostMapping()
    public PropertyResponse createProperty(@RequestBody PropertyRequest request) {
        var property = getMapper(PropertyMapper.class).map(request.getProperty());
        propertyService.create(property);
        return new PropertyResponse();
    }
}
