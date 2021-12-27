package info.behzadian.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/atm-service/health-check")
@RequiredArgsConstructor
@Slf4j
public class HealthCheckController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong!";
    }

}
