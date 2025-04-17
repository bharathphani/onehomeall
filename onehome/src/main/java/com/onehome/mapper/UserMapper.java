package com.onehome.mapper;

import com.onehome.dto.UserDto;
import com.onehome.entity.OnehomeUser;

public class UserMapper {
    public static UserDto mapToUserDto(OnehomeUser user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getMobileNo(),
                user.getAddressLine1(),
                user.getAddressLine2(),
                user.getPincode(),
                user.getCity(),
                user.getState());
    }

    public static OnehomeUser maptToUser(UserDto userDto) {
        return new OnehomeUser(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getMobileNo(),
                userDto.getAddressLine1(),
                userDto.getAddressLine2(),
                userDto.getPincode(),
                userDto.getCity(),
                userDto.getState());
    }
}