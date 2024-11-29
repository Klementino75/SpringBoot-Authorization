package ru.netology.springbootauthorization.repository;

import org.springframework.stereotype.Repository;

import ru.netology.springbootauthorization.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final List<Authorities> authorities = new ArrayList<>();

    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("Andrew") && password.equals("123")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Andrew") && password.equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("Andrew") && password.equals("12345")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}