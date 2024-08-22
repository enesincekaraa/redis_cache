package com.incekara.redis_cache.service;

import com.incekara.redis_cache.dto.CreateUserDto;
import com.incekara.redis_cache.dto.UpdateUserDto;
import com.incekara.redis_cache.mapper.UserMapper;
import com.incekara.redis_cache.model.User;
import com.incekara.redis_cache.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    @Cacheable(value = "users",key = "#root.methodName",unless = "#result == null")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @Cacheable(cacheNames = "user_id",key = "#root.methodName + #id",unless = "#result == null")
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }


    @CacheEvict(value = {"users","user_id"},allEntries = true)
    public User createUser(CreateUserDto dto) {
        User user =UserMapper.mapToUser(dto,new User());
        var savedUser = repository.save(user);
        return savedUser;
    }


    @CachePut(cacheNames ="user_id",key = "'getUserById'+#updateUserDto.id",unless = "#result == null")
    public User updateUser(UpdateUserDto updateUserDto) {
        Optional<User> updateUser=repository.findById(updateUserDto.getId());
        if (updateUser.isPresent()){
            User user1=updateUser.get();
            user1.setPassword(updateUserDto.getPassword());
            return repository.save(user1);
        }
        else {
            return null;
        }
    }

    @CacheEvict(value = {"users","user_id"},allEntries = true)
    public String deleteUser(Long id){
        repository.deleteById(id);
        return "User deleted";
    }
}
