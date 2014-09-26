package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;


public class MainMenuView extends ViewImpl implements MainMenuPresenter.MyView {
    public interface Binder extends UiBinder<Widget, MainMenuView> {
    }

    @Inject
    MainMenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
