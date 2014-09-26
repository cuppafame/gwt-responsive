package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.Widget;

public class HasManyVisibility  implements HasVisibility{

	final private HasVisibility[] widgets;
	
	public HasManyVisibility(HasVisibility... widget) {
		this.widgets = widget;
	}
	
	@Override
  public boolean isVisible() {
		for (HasVisibility w : widgets) {
			if (w.isVisible()) {
				return true;
			}
		}
		return false;
	}

	@Override
  public void setVisible(boolean visible) {
		for (HasVisibility w : widgets) {
			w.setVisible(visible);
		}
  }

}
