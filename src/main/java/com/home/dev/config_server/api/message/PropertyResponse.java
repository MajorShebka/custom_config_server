package com.home.dev.config_server.api.message;

import com.home.dev.config_server.api.model.PropertyApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponse {

    private List<PropertyApi> property;
}
