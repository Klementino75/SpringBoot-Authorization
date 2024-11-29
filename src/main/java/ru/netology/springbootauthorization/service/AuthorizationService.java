package ru.netology.springbootauthorization.service;

import org.springframework.stereotype.Service;

import ru.netology.springbootauthorization.exception.InvalidCredentials;
import ru.netology.springbootauthorization.exception.UnauthorizedUser;
import ru.netology.springbootauthorization.model.Authorities;
import ru.netology.springbootauthorization.model.User;
import ru.netology.springbootauthorization.repository.UserRepositoryInterface;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepositoryInterface userRepository;

    public AuthorizationService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty.");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getName(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}