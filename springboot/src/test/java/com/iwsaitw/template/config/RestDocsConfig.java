package com.iwsaitw.template.config;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

@Configuration
public class RestDocsConfig {

    @Bean
    public RestDocsSupport restDocsSupport() {
        return new RestDocsSupport();
    }

    @AutoConfigureRestDocs
    public static class RestDocsSupport {

        public RestDocumentationResultHandler failCaseDocs(String tag, String name, String code, String message) {
            return document(name,
                    resource(ResourceSnippetParameters.builder()
                            .tag(tag)
                            .responseFields(
                                    fieldWithPath("result").description("응답 결과 상태"),
                                    fieldWithPath("data").description("응답 데이터 (실패시 null)"),
                                    fieldWithPath("error").description("에러 정보 (성공시 null)"),
                                    fieldWithPath("error.code").description(code),
                                    fieldWithPath("error.message").description(message)
                            )
                            .build())
            );
        }
    }
}