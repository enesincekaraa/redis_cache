package com.incekara.redis_cache.mapper;

import com.incekara.redis_cache.dto.CreateUserDto;
import com.incekara.redis_cache.dto.UpdateUserDto;
import com.incekara.redis_cache.model.User;

public class UserMapper {

    public static CreateUserDto mapToUserDto(User user,CreateUserDto createUserDto){
        createUserDto.setUserName(user.getUserName());
        createUserDto.setPassword(user.getPassword());
        return  createUserDto;
    }

    public static User mapToUser(CreateUserDto createUserDto,User user){
        user.setUserName(createUserDto.getUserName());
        user.setPassword(createUserDto.getPassword());
        return user;
    }

    public static UpdateUserDto mapToUserDto(User user, UpdateUserDto updateUserDto){
        updateUserDto.setId(user.getId());
        updateUserDto.setUserName(user.getUserName());
        updateUserDto.setPassword(user.getPassword());
        return  updateUserDto;
    }

    public static User mapToUser(UpdateUserDto updateUserDto,User user){
        user.setId(updateUserDto.getId());
        user.setUserName(updateUserDto.getUserName());
        user.setPassword(updateUserDto.getPassword());
        return user;
    }
}
