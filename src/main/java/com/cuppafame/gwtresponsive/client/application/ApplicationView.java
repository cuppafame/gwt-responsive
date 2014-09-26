package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements
		ApplicationPresenter.MyView {
	public interface Binder extends UiBinder<Widget, ApplicationView> {
	}

	@UiField
	Panel rootPanel, scrollPanel, mainMenuContainer, centerContainer,
			centerPanel, northSlot;

	@UiField
	ToggleButton toggleMenu;

	@UiField
	Anchor login;
	
	@Inject
	ApplicationView(Binder uiBinder) {
		
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void toggleMenu(boolean forced) {
		rootPanel.getElement().setAttribute("menu", forced ? "force" : "auto");
	}

	@Override
	public HasValue<Boolean> getMenuToggled() {
		return toggleMenu;
	}

	
	
	@Override
	public HasClickHandlers getLoginClick() {
		return login;
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ApplicationPresenter.SLOT_SetMainContent) {
			centerPanel.clear();
			centerPanel.add(content);
		} else if (slot == ApplicationPresenter.SLOT_SetMenuContent) {
			mainMenuContainer.clear();
			mainMenuContainer.add(content);
		} else {
			super.setInSlot(slot, content);
		}
	}
}
