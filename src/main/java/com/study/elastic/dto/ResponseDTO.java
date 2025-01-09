package com.study.elastic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "common response")
public class ResponseDTO<T> {

    @Schema(description = "api response code")
    private int code;

    @Schema(description = "api msg", example = "success/error")
    private String msg; //에러 또는 성공 메세지 제공

    @Schema(description = "body data")
    private T body;


}
