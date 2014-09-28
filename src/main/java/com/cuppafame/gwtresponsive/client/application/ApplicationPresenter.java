package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.application.login.LoginEvent;
import com.cuppafame.gwtresponsive.client.application.login.LoginPopupPresenter;
import com.cuppafame.gwtresponsive.client.resources.MainMessages;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class ApplicationPresenter extends
		Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	public interface MyView extends View {
		HasValue<Boolean> getMenuToggled();

		HasClickHandlers getLoginClick();

		HasText getLoginText();

		HasText getWelcomeMessage();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMenuContent = new Type<>();

	@ProxyStandard
	public interface MyProxy extends Proxy<ApplicationPresenter> {
	}

	private final LoginPopupPresenter loginPopup;
	private final MainMessages msg;

	private String user;

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
			MainMessages msg, MainMenuPresenter mainMenu,
			LoginPopupPresenter loginPopup) {
		super(eventBus, view, proxy, RevealType.Root);
		this.loginPopup = loginPopup;
		this.msg = msg;
		setInSlot(SLOT_SetMenuContent, mainMenu);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getLoginClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// we use same login anchor for both login and logout
				if (user == null) {
					addToPopupSlot(loginPopup);
				} else {
					// log out will fully reload the application thus it will be
					// in not-logged in state
					logout();
				}

			}
		});
		getEventBus().addHandler(LoginEvent.TYPE, new LoginEvent.LoginHandler() {

			@Override
			public void onLogin(LoginEvent event) {
				user = event.getUser();
				//change login anchor text to logout
				getView().getLoginText().setText(msg.logout());
				getView().getWelcomeMessage().setText(msg.welcome(user));

			}
		});
	}

	@Override
	protected void onReset() {
		super.onReset();
		getView().getMenuToggled().setValue(false, true);
	}

	private void logout() {
		String currentLocation = Window.Location.getHref();
		int sharp = currentLocation.indexOf("#");
		if (sharp != -1) {
			currentLocation = currentLocation.substring(0, sharp);
		}
		Window.Location.replace(currentLocation);
	}

}
