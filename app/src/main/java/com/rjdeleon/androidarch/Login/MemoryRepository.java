package com.rjdeleon.androidarch.Login;

public class MemoryRepository implements LoginRepository {

    private User user;



    @Override
    public User getUser() {

        if (user == null) {
            User user = new User("Fox", "Mulder");
            user.setId(0);
            return user;
        }
        return this.user;
    }

    @Override
    public void saveUser(User user) {

        if (user == null) {
            user = getUser();
        }
        this.user = user;

    }

}
