package com.onehome.socialsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus status;
    private String errorMsg;

}
