package no.hiof.webframework.SpringBoot.Components;

import org.springframework.stereotype.Component;

@Component
public class Endpoint {
    private String endpointValue;

    public Endpoint() {}

    public Endpoint(String endpoint) {
        this.endpointValue = endpoint;
    }

    public String getEndpointValue() {
        return endpointValue;
    }

    public void setEndpointValue(String endpointValue) {
        this.endpointValue = endpointValue;
    }
}
