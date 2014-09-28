package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.user.client.ui.HasEnabled;

/**
 * HasMany adapter that supports multiple widgets at a time.
 *
 */
public class HasManyEnabled  implements HasEnabled {

	final private HasEnabled[] widgets;
	
	public HasManyEnabled(HasEnabled... widget) {
		this.widgets = widget;
	}
	
	@Override
  public boolean isEnabled() {
		for (HasEnabled w : widgets) {
			if (w.isEnabled()) {
				return true;
			}
		}
		return false;
	}

	@Override
  public void setEnabled(boolean enabled) {
		for (HasEnabled w : widgets) {
			w.setEnabled(enabled);
		}
  }

}
