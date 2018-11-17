package com.gautams.pos.view.splash;

import android.arch.lifecycle.ViewModelProviders;

import com.gautams.pos.repository.UserRepository;
import com.gautams.pos.view.splash.vm.SplashActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * User_1 Name: gautams2
 * Create Date : 5/31/2018
 */

@Module
public class SplashActivityModule {

    @Provides
    public SplashActivityViewModel mainActivityViewModel(SplashActivity splashActivity, UserRepository userRepository) {
        SplashActivityViewModel vm = ViewModelProviders.of(splashActivity).get(SplashActivityViewModel.class);
        vm.setUserRepository(userRepository);
        return vm;
    }

}
