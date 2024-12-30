package com.home.dev.config_server.api.message;

import com.home.dev.config_server.api.model.PropertyApi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyRequest {

    private PropertyApi property;
}
