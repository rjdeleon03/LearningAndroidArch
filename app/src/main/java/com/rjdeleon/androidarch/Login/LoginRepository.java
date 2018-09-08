package com.rjdeleon.androidarch.Login;

public interface LoginRepository {

    User getUser();

    void saveUser(User user);

}
