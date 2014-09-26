package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class MainMenuPresenter extends PresenterWidget<MainMenuPresenter.MyView> {
    public interface MyView extends View {
    }

    @Inject
    MainMenuPresenter(EventBus eventBus, MyView view) {
        super(eventBus, view);
    }

    
}
