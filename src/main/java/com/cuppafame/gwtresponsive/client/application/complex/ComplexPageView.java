package com.cuppafame.gwtresponsive.client.application.complex;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ComplexPageView extends ViewImpl implements ComplexPresenter.MyView {
    public interface Binder extends UiBinder<Widget, ComplexPageView> {
    }

    @Inject
    ComplexPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
