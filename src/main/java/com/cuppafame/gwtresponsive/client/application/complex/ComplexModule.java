package com.cuppafame.gwtresponsive.client.application.complex;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ComplexModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ComplexPresenter.class, ComplexPresenter.MyView.class, ComplexPageView.class,
                ComplexPresenter.MyProxy.class);
    }
}
