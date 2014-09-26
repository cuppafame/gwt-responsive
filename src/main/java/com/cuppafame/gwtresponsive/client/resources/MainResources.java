package com.cuppafame.gwtresponsive.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface MainResources extends ClientBundle {
	@NotStrict
	@Source("css/Main.css")
	MainStyles css();

	@Source("css/Mobile.css")
	TextResource mobile();

	@Source("images/main-menu.png")
	ImageResource mainMenu24px();

	@Source("images/internet_map.png")
	ImageResource internetMap();
	
    @Source("TermsOfUse.html")  
    public TextResource termsOfUse();	
}
