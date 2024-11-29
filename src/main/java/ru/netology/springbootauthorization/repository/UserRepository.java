package ru.netology.springbootauthorization.repository;

import org.springframework.stereotype.Repository;

import ru.netology.springbootauthorization.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();

        if (user.equals("Andrew") && password.equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        }
        return authorities;
    }
}