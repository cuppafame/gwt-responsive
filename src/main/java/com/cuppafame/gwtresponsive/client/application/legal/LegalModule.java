package com.cuppafame.gwtresponsive.client.application.legal;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LegalModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(LegalPagePresenter.class, LegalPagePresenter.MyView.class, LegalPageView.class,
                LegalPagePresenter.MyProxy.class);
    }
}
