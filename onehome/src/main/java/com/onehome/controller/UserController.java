package com.onehome.controller;


import com.onehome.constants.Constants;
import com.onehome.dto.ErrorResponseDto;
import com.onehome.dto.ResponseDto;
import com.onehome.dto.UserDto;
import com.onehome.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Service" , description = "User Service creates, updates and fetch users")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {
    private IUserService iUserService;
    @Value("${contact.version}")
    private String buildVersion;
    @Value("${contact.envi}")
    private String envi;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ApiResponse(responseCode = "200", description = "health is retrieved successfully")
    @Operation(summary = "User Service Health", description = "To test the user service health")
    @GetMapping(path = "health")
    public String sayHello() {
        return "User service is healthy";
    }

    // if any error with 500 code will show more details
    @ApiResponse(responseCode = "200", description = "User Created successfully")
    @ApiResponse(responseCode = "500",
                 description = "Server Error",
                 content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @ApiResponse(responseCode = "400",
            description = "Bad Request",
            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @Operation(summary = "create user", description = "Creates user and throws exception if there already")
    @PostMapping(path = "create")
    public ResponseEntity<ResponseDto> createUser(@Valid  @RequestBody UserDto userDto) {
        iUserService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(Constants.HTTP_CODE_201, Constants.USER_SUCCESS_MSG_201));
    }

    @ApiResponse(responseCode = "200", description = "User fetched successfully")
    @Operation(summary = "fetch user", description = "fetch single user matching criteria")
    @GetMapping(path= "fetch")
    public ResponseEntity<UserDto> getUserByMobileNo(@RequestParam String mobileNo) {
        UserDto userDto = iUserService.getUser(mobileNo);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @ApiResponse(responseCode = "200", description = "All User fetched successfully")
    @Operation(summary = "fetch all users", description = "fetch all available users")
    @GetMapping(path= "fetchall")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = iUserService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userDtos);
    }

    @Operation(summary = "gets build info", description = "get build and version info")
    @GetMapping(path= "buildinfo")
    public ResponseEntity<String> getBuildAndEnvi() {
        return ResponseEntity.status(HttpStatus.OK).body("version = "+this.buildVersion+" envi = "+this.envi);
    }
}
