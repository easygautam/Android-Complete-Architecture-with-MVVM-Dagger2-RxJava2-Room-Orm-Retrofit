package com.gautams.pos.view.login;

import android.arch.lifecycle.ViewModelProviders;

import com.gautams.pos.repository.UserRepository;
import com.gautams.pos.view.login.vm.LoginActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * User Name: gautams2
 * Create Date : 5/31/2018
 */

@Module
public class LoginActivityModule {

    @Provides
    public LoginActivityViewModel loginActivityViewModel(LoginActivity loginActivity,
                                                             UserRepository userRepository) {
        LoginActivityViewModel vm = ViewModelProviders.of(loginActivity).get(LoginActivityViewModel.class);
        vm.setUserRepository(userRepository);
        return vm;
    }

}
