package com.cuppafame.gwtresponsive.client.application.rv;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class RVPageView extends ViewImpl implements RVPagePresenter.MyView {
    public interface Binder extends UiBinder<Widget, RVPageView> {
    }

    @Inject
    RVPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
