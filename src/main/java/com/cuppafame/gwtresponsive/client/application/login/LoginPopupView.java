package com.cuppafame.gwtresponsive.client.application.login;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.common.HasManyClickHandlers;
import com.cuppafame.gwtresponsive.client.common.ResponsiveDialog;
import com.cuppafame.gwtresponsive.client.resources.MainMessages;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

public class LoginPopupView extends PopupViewImpl implements LoginPopupPresenter.MyView {
    public interface Binder extends UiBinder<Widget, LoginPopupView> {
    }

    @UiField ResponsiveDialog dialog;
    @UiField TextBox user, password;
    @UiField Button loginButton, cancelButton;
    
    @Inject
    LoginPopupView(EventBus eventBus, Binder uiBinder, MainMessages msg) {
    	super(eventBus);
        initWidget(uiBinder.createAndBindUi(this));
        
        //GWT TextBox as of 2.6 does not support placeholders so we put it using DOM
        user.getElement().setAttribute("placeholder", msg.userPlaceholder());
        password.getElement().setAttribute("placeholder", msg.passwordPlaceholder());
        
        //change login button enabled state based on user input
        //TODO: this solution is not comprehensive as it does not solves copy/cut/paste scenrios
        user.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				
				loginButton.setEnabled(!user.getText().trim().isEmpty());
			}
		});
        //focus user field on attach
        asWidget().addAttachHandler(new Handler() {
			
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					user.setFocus(true);
				}
				
			}
		});
    }

	@Override
	public HasClickHandlers getLoginClick() {
		return new HasManyClickHandlers(loginButton, dialog.getOKHandler());
	}

	@Override
	public HasClickHandlers getCancelClick() {
		return new HasManyClickHandlers(cancelButton, dialog.getCancelHandler());
	}

	@Override
	public HasText getUser() {
		return user;
	}
}
