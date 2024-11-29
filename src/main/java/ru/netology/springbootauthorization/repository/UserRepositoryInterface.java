package ru.netology.springbootauthorization.repository;

import ru.netology.springbootauthorization.model.Authorities;

import java.util.List;

public interface UserRepositoryInterface {

    List<Authorities> getUserAuthorities(String user, String password);
}