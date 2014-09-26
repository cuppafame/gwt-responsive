package com.cuppafame.gwtresponsive.client.gin;

import com.cuppafame.gwtresponsive.client.resources.MainResources;
import com.google.gwt.dom.client.StyleInjector;
import com.google.inject.Inject;

public class ResourceLoader {
	@Inject
	ResourceLoader(MainResources resources) {
		resources.css().ensureInjected();

		String mobileCss = resources.mobile().getText();
		StyleInjector.injectAtEnd(mobileCss);
	}

}
