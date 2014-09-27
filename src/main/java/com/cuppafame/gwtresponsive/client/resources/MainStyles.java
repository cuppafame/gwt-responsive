package com.cuppafame.gwtresponsive.client.resources;

import com.google.gwt.resources.client.CssResource;

public interface MainStyles extends CssResource {
	String mainRootPanel();
	String mainScrollPanel();
	String mainNorthPanel();
	String mainStackPanel();
	String mainStackPanelHeader();
	String mainPlacePanel();
	String mainPlacePanelCover();
	String mainPlaceContainer();
	String mainMenuContainer();
	String mainMenu();
	String mainMenuToggler();
	String login();
	String formPanel();
	String formFooter();
	String formField();
	String cardTitle();
	String cardTitleText();
	String rvTable();
	String rvImage();
	
	@CssResource.ClassName("mobi-rvPan")
	String mobiRvPan();
	
	@CssResource.ClassName("mobi-rv-leftPan")
	String mobiRvLeftPan();
	
	@CssResource.ClassName("mobi-rv-rightPan")
	String mobiRvRightPan();
}
