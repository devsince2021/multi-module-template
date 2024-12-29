package com.iwsaitw.template.api.health;

import com.iwsaitw.template.api.constant.API;
import com.iwsaitw.base.web.response.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.V1.HEALTH)
public class HealthController {

    @GetMapping
    public Response<String> checkHealth() {
        String result = "work";
        return Response.success(result);
    }
}
