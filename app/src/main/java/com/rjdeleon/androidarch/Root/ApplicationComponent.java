package com.rjdeleon.androidarch.Root;

import com.rjdeleon.androidarch.Login.LoginActivity;
import com.rjdeleon.androidarch.Login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
            ApplicationModule.class,
            LoginModule.class
        })
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
