package com.cuppafame.gwtresponsive.client.application.login;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class LoginPopupPresenter extends PresenterWidget<LoginPopupPresenter.MyView> {
    public interface MyView extends PopupView {
    	HasClickHandlers getLoginClick();
    	HasClickHandlers getCancelClick();
    	HasText getUser();
    }

    @Inject
    LoginPopupPresenter(EventBus eventBus,
                      MyView view) {
        super(eventBus, view);
    }

	@Override
	protected void onBind() {
		super.onBind();
		getView().getLoginClick().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
				//TODO: real login logic is out of scope of this demo
				getEventBus().fireEvent(new LoginEvent(getView().getUser().getText()));
			}
		});
		getView().getCancelClick().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
				
			}
		});
	}
    
    
}
