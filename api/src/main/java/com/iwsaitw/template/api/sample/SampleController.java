package com.iwsaitw.template.api.sample;

import com.iwsaitw.template.api.constant.API;
import com.iwsaitw.template.core.domain.SampleDomain;
import com.iwsaitw.template.core.domain.SampleService;
import com.iwsaitw.utils.exception.BaseException;
import com.iwsaitw.utils.exception.code.ArgumentExceptionCode;
import com.iwsaitw.utils.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.V1.SAMPLE)
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping
    public Response<SampleResponse> createSample(
            @RequestBody SampleRequest request
    ) {
        if (request.getName().isBlank()) {
            throw new BaseException(ArgumentExceptionCode.WA001);
        }

        SampleDomain domain = sampleService.createSample(request.getName());

        SampleResponse response = new SampleResponse(domain.getId(), domain.getName(), 1L);

        return Response.success(response);
    }
}
