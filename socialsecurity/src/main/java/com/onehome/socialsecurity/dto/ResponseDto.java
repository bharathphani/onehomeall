package com.onehome.socialsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class ResponseDto {
    private String satatusCode;
    private String msg;
}
