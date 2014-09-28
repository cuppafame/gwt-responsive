package com.cuppafame.gwtresponsive.client.application.login;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class LoginEvent extends GwtEvent<LoginEvent.LoginHandler> {

	public static Type<LoginHandler> TYPE = new Type<LoginHandler>();
	private final String user;

	public interface LoginHandler extends EventHandler {
		void onLogin(LoginEvent event);
	}

	public LoginEvent(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	@Override
	protected void dispatch(LoginHandler handler) {
		handler.onLogin(this);
	}

	@Override
	public Type<LoginHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<LoginHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, String user) {
		source.fireEvent(new LoginEvent(user));
	}
}
