package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.application.login.LoginPopupPresenter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    public interface MyView extends View {
    	HasValue<Boolean> getMenuToggled();
		void toggleMenu(boolean forced);
		HasClickHandlers getLoginClick();
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<>();

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetMenuContent = new Type<>();

    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter> {
    }
    
    private final LoginPopupPresenter loginPopup;

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy,
                         MainMenuPresenter mainMenu,
                         LoginPopupPresenter loginPopup) {
        super(eventBus, view, proxy, RevealType.Root);
        this.loginPopup = loginPopup;
        setInSlot(SLOT_SetMenuContent, mainMenu);
    }

	@Override
	protected void onBind() {
		super.onBind();
		//default is not to force menu (auto mode)
		getView().toggleMenu(false); 
		
		Window.addResizeHandler(new ResizeHandler() {
			
			@Override
			public void onResize(ResizeEvent event) {
				//on scroll unforce the menu (auto mode)
				getView().toggleMenu(false); 
				getView().getMenuToggled().setValue(false, false);
			}
		});
		
		getView().getMenuToggled().addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				//only possible in mobile view
				//force/unforce the menu on user two-state button click
				boolean forced = event.getValue();
				getView().toggleMenu(forced); 
				//scroll to top if the user forces the menu to appear in mobile view
				Window.scrollTo(0, 0);
				
			}
		});
		
		getView().getLoginClick().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addToPopupSlot(loginPopup);
				
			}
		});
		
	}

	@Override
	protected void onReset() {
		super.onReset();
		//unforce the menu
		getView().toggleMenu(false); 
		getView().getMenuToggled().setValue(false, false);
	}
    
	
}
