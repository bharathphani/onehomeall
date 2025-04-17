package com.onehome.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Onehome user", description="One user details")
public class UserDto {
    private long id;

    @Schema(description = "Full Name", example = "John Wesley")
    private String name;

    @Schema(description = "Valid Email", example = "abc@example.com")
    private String email;

    @Size(min= 10, max= 10)
    @Schema(description = "Mob No 10 digits")
    private String mobileNo;

    private String addressLine1;

    private String addressLine2;

    @Size(min= 6, max= 6)
    @Schema(description = "Pincode 6 digits")
    private String pincode;

    private String city;

    private String state;
}

