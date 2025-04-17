package com.onehome.service;


import com.onehome.dto.UserDto;

import java.util.List;

public interface IUserService {
    public void createUser(UserDto userDto);
    public UserDto getUser(String mobileNo);
    public List<UserDto> getAllUsers();
}