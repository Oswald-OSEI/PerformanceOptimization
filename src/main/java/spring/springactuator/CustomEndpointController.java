package spring.springactuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "customInfo")
public class CustomEndpointController {

    @ReadOperation
    public Map<String, String> customInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("app-version", "1.0.0");
        info.put("description", "Custom Actuator Endpoint for Application Info");
        return info;
    }
}