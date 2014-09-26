package com.cuppafame.gwtresponsive.client.application.login;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LoginModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenterWidget(LoginPopupPresenter.class, LoginPopupPresenter.MyView.class, LoginPopupView.class);
    }
}
