package com.cuppafame.gwtresponsive.client.application.about;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AboutModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(AboutPagePresenter.class, AboutPagePresenter.MyView.class, AboutPageView.class,
                AboutPagePresenter.MyProxy.class);
    }
}
