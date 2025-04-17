package com.epf.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Effet {
    @JsonProperty("normal")
    NORMAL,
    
    @JsonProperty("slow_low")
    SLOW_LOW,
    
    @JsonProperty("slow_medium")
    SLOW_MEDIUM,
    
    @JsonProperty("slow_stop")
    SLOW_STOP
}