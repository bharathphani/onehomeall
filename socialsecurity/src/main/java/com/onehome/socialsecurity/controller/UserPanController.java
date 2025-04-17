package com.onehome.socialsecurity.controller;

import com.onehome.socialsecurity.constants.Constants;
import com.onehome.socialsecurity.dto.ErrorResponseDto;
import com.onehome.socialsecurity.dto.PanDto;
import com.onehome.socialsecurity.dto.ResponseDto;
import com.onehome.socialsecurity.service.IUserPanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pan Service" , description = "Pan Service creates, updates and Pan details for user")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pan", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class UserPanController {
    private IUserPanService panService;

    @ApiResponse(responseCode = "200", description = "health is retrieved successfully")
    @Operation(summary = "Pan Service Health", description = "To test the pan service health")
    @GetMapping(path = "health")
    public String sayHello() {
        return "pan service is healthy";
    }

    // if any error with 500 code will show more details
    @ApiResponse(responseCode = "200", description = "Pan Created successfully")
    @ApiResponse(responseCode = "500",
            description = "Server Error",
            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @ApiResponse(responseCode = "400",
            description = "Bad Request",
            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @Operation(summary = "create pan", description = "Creates pan and throws exception if there already")
    @PostMapping(path = "create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody PanDto panDto) {
        panService.createUserPan(panDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(Constants.HTTP_CODE_201, Constants.PAN_SUCCESS_MSG_201));
    }



}
