package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * HasManyClickHandlers adapter that supports multiple widgets at a time.
 *
 */
public class HasManyClickHandlers implements HasClickHandlers {

	private final HasClickHandlers[] clicks;
	
	public HasManyClickHandlers(HasClickHandlers... clicks) {
		this.clicks = clicks;
	}
	
	
	@Override
  public void fireEvent(GwtEvent<?> event) {
	  for (HasClickHandlers click : clicks) {
	  	click.fireEvent(event);
	  	break;
	  }
  }

	@Override
  public HandlerRegistration addClickHandler(ClickHandler handler) {
	  for (HasClickHandlers click : clicks) {
	  	click.addClickHandler(handler);
	  }
	  return null;
  }

}
