package com.cuppafame.gwtresponsive.client.application;

import com.cuppafame.gwtresponsive.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);

        bindSingletonPresenterWidget(MainMenuPresenter.class, MainMenuPresenter.MyView.class, MainMenuView.class);
    }
}
