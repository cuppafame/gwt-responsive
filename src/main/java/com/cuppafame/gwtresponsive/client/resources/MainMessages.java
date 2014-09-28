package com.cuppafame.gwtresponsive.client.resources;

import com.google.gwt.i18n.client.Messages;
import com.google.gwt.safehtml.shared.SafeHtml;

public interface MainMessages extends Messages {
	String   helloResponsive();
	String   login();
	String   logout();
	String   welcome(String user);
	SafeHtml about();
	SafeHtml internet();

	String userPlaceholder();
	String passwordPlaceholder();
	String loginButton();
	String cancelButton();
	
	String mainMenuItemComplex();
	String mainMenuCategory1();
	String mainMenuItemHome();
	String mainMenuItemAbout();
	String mainMenuCategory2();
	String mainMenuItemTOU();
	String mainMenuItemPrivacy();
}
