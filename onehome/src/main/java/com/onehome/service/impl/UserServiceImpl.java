package com.onehome.service.impl;

import com.onehome.dto.UserDto;
import com.onehome.entity.OnehomeUser;
import com.onehome.exception.ResourceNotFoundException;
import com.onehome.exception.UserAlreadyExistsException;
import com.onehome.mapper.UserMapper;
import com.onehome.repositary.UserRepositary;
import com.onehome.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepositary userRepo;

    @Override
    public void createUser(UserDto userDto) {
        OnehomeUser user = UserMapper.maptToUser(userDto);
        Optional<OnehomeUser> userOpt = userRepo.findByMobileNoAndEmail(user.getMobileNo(), user.getEmail());
        if(userOpt.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("Bharath");
        user.setModifiedOn(LocalDateTime.now());
        user.setModifiedBy("Bharath");
        OnehomeUser savedUser = userRepo.save(user);
    }

    @Override
    public UserDto getUser(String mobileNo) {
        OnehomeUser user = userRepo.findByMobileNo(mobileNo).orElseThrow(
                () -> new ResourceNotFoundException("User", "mobileNo", mobileNo)
        );
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<OnehomeUser> users = userRepo.findAll();
        return Arrays.stream(users.stream().toArray()).map(user -> UserMapper.mapToUserDto((OnehomeUser)user)).collect(Collectors.toList());
    }
}

