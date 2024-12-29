package com.iwsaitw.template.sample;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.iwsaitw.template.api.constant.API;
import com.iwsaitw.template.api.sample.SampleResponse;
import com.iwsaitw.template.config.RestDocsConfig;
import com.iwsaitw.template.sample.fixture.SampleRequestTestFixtures;
import com.iwsaitw.template.sample.fixture.SampleResponseTestFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Import(RestDocsConfig.class)
public class CreateSampleTest {
    private static final String base = API.V1.SAMPLE;
    private static final String tag = "Sample";

    @Autowired
    private RestDocsConfig.RestDocsSupport restDocsSupport;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void should_return_sample_when_request_has_name() throws Exception {
        String testName = "test name";
        String request = SampleRequestTestFixtures.createValidForm(testName);
        SampleResponse response = SampleResponseTestFixtures.successResponse(testName);

        mockMvc.perform(post(base)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpectAll(assertSample(response))
                .andDo(createSuccessDocs("success-case"));
    }

    @Test
    public void should_return_fail_response_when_name_is_null() throws Exception {
        String emptyNameRequest = SampleRequestTestFixtures.createEmptyNameForm();

        mockMvc.perform(post(base)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(emptyNameRequest))
                .andExpect(status().isBadRequest())
                .andExpectAll(assertFailResponse("F400-WA001", "must not be blank"))
                .andDo(restDocsSupport.failCaseDocs(tag, "empty-name", "F400-WA001", "must not be blank"));
    }

    private RestDocumentationResultHandler createSuccessDocs(String name) {
        return document(name,
                resource(ResourceSnippetParameters.builder()
                        .tag(tag)
                        .responseFields(
                                fieldWithPath("result").description("응답 결과 상태"),
                                fieldWithPath("data").description("응답 데이터"),
                                fieldWithPath("data.id").description("샘플 id"),
                                fieldWithPath("data.name").description("샘플 이름"),
                                fieldWithPath("data.timestamp").description("현재 시간"),
                                fieldWithPath("error").description("에러 정보 (성공시 null)")
                        )
                        .build())
        );
    }


    private ResultMatcher[] assertSample(SampleResponse response) {
        return new ResultMatcher[]{
                jsonPath("$.result").value("SUCCESS"),
                jsonPath("$.data.id").exists(),
                jsonPath("$.data.name").value(response.getName()),
                jsonPath("$.data.timestamp").value(response.getTimestamp()),
                jsonPath("$.error").doesNotExist(),
        };
    }

    protected ResultMatcher[] assertFailResponse(String code, String message) {
        return new ResultMatcher[]{
                jsonPath("$.result").value("FAIL"),
                jsonPath("$.data").doesNotExist(),
                jsonPath("$.error.code").value(code),
                jsonPath("$.error.message").value(message)
        };
    }
}
