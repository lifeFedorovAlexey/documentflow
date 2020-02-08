package com.documentflow.services;

import com.documentflow.entities.Department;
import com.documentflow.entities.User;
import com.documentflow.repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Setter(onMethod_ = {@Autowired})
    private UserRepository userRepository;

    @Override
    public User getCurrentUser(int userId) {
        return userRepository.findOneById(userId);
    }

    @Override
    public User getBoss(int userId) {
        return userRepository.findOneById(userId).getBoss();
    }

    @Override
    public Department getDepartmentByUserId(int userId) {
        return userRepository.findOneById(userId).getDepartment();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getPageOfUsersBySpecification(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
