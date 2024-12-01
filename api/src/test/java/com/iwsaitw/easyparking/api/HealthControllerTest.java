package com.iwsaitw.easyparking.api;

import com.iwsaitw.easyparking.application.SampleService;
import com.iwsaitw.easyparking.core.domain.SampleDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ContextConfiguration(classes = {HealthController.class})
@WebMvcTest(HealthController.class)
@AutoConfigureRestDocs
public class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleService sampleService;

    @Test
    void contextLoads() {
    }

    @Test
    void healthCheck() throws Exception {
        // given
        when(sampleService.test()).thenReturn("test result");

        // when & then
        mockMvc.perform(get("/health")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Health"))
                .andDo(createHealthCheckDocs());
    }

    private RestDocumentationResultHandler createHealthCheckDocs() {
        return document("health-check",
                responseBody(),
                responseFields(
                        fieldWithPath("message").description("Health check response message")
                )
        );
    }


    @Test
    public void should_return_sample_when_request_has_name() throws Exception {
        String path = "/sample";
        String req = "{ \"name\": \"test-name\"}";

        String name = "test-name";

        when(sampleService.createSample(name)).thenReturn(new SampleDomain(0L, name));

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("0"))
                .andExpect(jsonPath("$.name").value(name))
                .andDo(createDocs());
    }

    private RestDocumentationResultHandler createDocs() {
        return document("sample-create",
                requestFields(
                        fieldWithPath("name").description("The name of the sample to create")
                ),
                responseFields(
                        fieldWithPath("id").description("The unique identifier of the sample"),
                        fieldWithPath("name").description("The name of the sample")
                )
        );
    }

}
