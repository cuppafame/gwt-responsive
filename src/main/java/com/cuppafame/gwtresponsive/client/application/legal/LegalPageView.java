package com.cuppafame.gwtresponsive.client.application.legal;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class LegalPageView extends ViewImpl implements LegalPagePresenter.MyView {
    public interface Binder extends UiBinder<Widget, LegalPageView> {
    }

    @UiField HTML touPanel;
    
    @Inject
    LegalPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    public HasHTML getHtmlPanel() {
    	return touPanel;
    }
}
