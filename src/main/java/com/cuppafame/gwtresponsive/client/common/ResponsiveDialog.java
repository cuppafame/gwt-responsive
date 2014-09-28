package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasVisibility;

/**
 * Custom dialog with ok and cancel buttons built into the caption.
 *
 */
public class ResponsiveDialog extends DialogBox {
	private final ResponsiveDialogCaption caption;

	public ResponsiveDialog() {
		super(new ResponsiveDialogCaption());

		caption = (ResponsiveDialogCaption) this.getCaption();
	}

	public HasVisibility getOKVisibility() {
		return caption.getOKVisibility();
	}

	public HasEnabled getOKEnabled() {
		return caption.getOKEnabled();
	}

	public HasVisibility getCancelVisibility() {
		return caption.getCancelVisibility();
	}

	public HasClickHandlers getOKHandler() {
		return caption.getOKClick();
	}

	public HasClickHandlers getCancelHandler() {
		return caption.getCancelClick();
	}
}
