package com.cuppafame.gwtresponsive.client.application;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
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
	
	@UiField
	Label welcome;
	
	@Inject
	ApplicationView(Binder uiBinder) {
		
		initWidget(uiBinder.createAndBindUi(this));

		rootPanel.getElement().setAttribute("menu", "off");
		Window.addResizeHandler(new ResizeHandler() {
			
			@Override
			public void onResize(ResizeEvent event) {
				//on resize hide the menu
				toggleMenu.setValue(false, true);
			}
		});
		
		toggleMenu.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				//only available in mobile view
				//toggle the menu as a reaction to two-state button click
				rootPanel.getElement().setAttribute("menu", event.getValue() ? "on" : "off");
				//scroll to top if the user forces the menu to appear in mobile view
				Window.scrollTo(0, 0);
				
			}
		});
		
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
	public HasText getLoginText() {
		return login;
	}

	@Override
	public HasText getWelcomeMessage() {
		return welcome;
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
