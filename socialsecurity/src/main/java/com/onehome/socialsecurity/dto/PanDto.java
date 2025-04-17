package com.onehome.socialsecurity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class PanDto {

    @Schema(description = "USER ID FROM ONEHOME USER")
    private long id;

    @Size(min= 10, max= 10)
    @Schema(description = "PAN", example = "XXXXX8459X")
    private String pan;

    @Schema(description = "Full Name", example = "John Wesley")
    private String name;

    @Size(min= 10, max= 10)
    @Schema(description = "Mob No 10 digits")
    private String mobileNo;
}