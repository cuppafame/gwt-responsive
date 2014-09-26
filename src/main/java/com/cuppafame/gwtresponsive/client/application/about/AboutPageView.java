package com.cuppafame.gwtresponsive.client.application.about;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class AboutPageView extends ViewImpl implements AboutPagePresenter.MyView {
    public interface Binder extends UiBinder<Widget, AboutPageView> {
    }

    @Inject
    AboutPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
