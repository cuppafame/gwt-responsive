package com.cuppafame.gwtresponsive.client.application.rv;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RVModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RVPagePresenter.class, RVPagePresenter.MyView.class, RVPageView.class,
                RVPagePresenter.MyProxy.class);
    }
}
