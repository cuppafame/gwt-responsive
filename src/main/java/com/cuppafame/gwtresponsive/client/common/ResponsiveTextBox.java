package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class ResponsiveTextBox extends TextBox {

	private boolean selectAllOnFocus = false;
	private String placeholder;
	private boolean placeholderVisible = true;

	public ResponsiveTextBox() {
		addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent event) {
				if (selectAllOnFocus) {
					selectAll();
				}
			}
		});

	}

	public void setControlType(String type) {
		getElement().setAttribute("type", type);
	}

	public void setAutoCorrect(boolean autocorrect) {
		getElement().setAttribute("autocorrect", autocorrect ? "on" : "off");
	}

	public void setAutoCapitalize(boolean autocapitalize) {
		getElement().setAttribute("autocapitalize",
				autocapitalize ? "on" : "off");
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String value) {
		this.placeholder = value;
		if (value != null && placeholderVisible) {
			getElement().setAttribute("placeholder", value);
		} else {
			getElement().removeAttribute("placeholder");
		}

	}

	public boolean isSelectAllOnFocus() {
		return selectAllOnFocus;
	}

	public void setSelectAllOnFocus(boolean selectAllOnFocus) {
		this.selectAllOnFocus = selectAllOnFocus;
	}

	public boolean isPlaceholderVisible() {
		return placeholderVisible;
	}

	public void setPlaceholderVisible(boolean placeholderVisible) {
		this.placeholderVisible = placeholderVisible;
		if (placeholder != null && placeholderVisible) {
			getElement().setAttribute("placeholder", placeholder);
		} else {
			getElement().removeAttribute("placeholder");
		}
	}

}
