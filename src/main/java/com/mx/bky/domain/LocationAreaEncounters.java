package com.mx.bky.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationAreaEncounters {
    

    public LocationArea location_area;

    
}
