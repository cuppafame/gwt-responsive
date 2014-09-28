package com.cuppafame.gwtresponsive.client.common;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.InlineHTML;

/**
 * Custom dialog caption with ok and cancel buttons built in
 *
 */
public class ResponsiveDialogCaption extends Composite implements
		DialogBox.Caption, HasHTML {
	private FocusPanel panel = new FocusPanel();
	private FlowPanel widgets = new FlowPanel();
	private FlowPanel html = new FlowPanel();
	private InlineHTML text = new InlineHTML();
	private FlowPanel wrap = new FlowPanel();
	private Button close = new Button(
			SafeHtmlUtils
					.fromSafeConstant("<span style=\"font-size:1.3em;\">\u2716</span>"));
	private Button ok = new Button(
			SafeHtmlUtils
					.fromSafeConstant("<span style=\"font-size:1.3em;\">\u2714</span>"));

	public ResponsiveDialogCaption() {
		wrap.add(ok);
		wrap.add(close);

		ok.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
		close.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
		ok.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		close.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		close.addStyleName("gwt-CancelButton");

		widgets.add(html);
		widgets.add(wrap);
		widgets.setStyleName("Caption");

		panel.add(widgets);

		// text.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);

		html.add(text);

		html.getElement().getStyle().setProperty("display", "table-cell");
		html.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		html.getElement().getStyle().setWidth(100, Unit.PCT);
		wrap.getElement().getStyle().setWidth(4, Unit.EM);
		wrap.getElement().getStyle().setProperty("display", "table-cell");
		wrap.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
		wrap.getElement().getStyle().setWhiteSpace(WhiteSpace.NOWRAP);

		initWidget(panel);
	}

	public HasClickHandlers getCloseHandler() {
		return close;
	}

	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return panel.addMouseDownHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return panel.addMouseUpHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return panel.addMouseOutHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return panel.addMouseOverHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return panel.addMouseMoveHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		return panel.addMouseWheelHandler(handler);
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public void setText(String txt) {
		text.setText(txt);
	}

	@Override
	public void setHTML(SafeHtml h) {
		text.setHTML(h);
	}

	@Override
	public String getHTML() {
		return text.getHTML();
	}

	@Override
	public void setHTML(String h) {
		text.setHTML(h);
	}

	public HasVisibility getOKVisibility() {
		return ok;
	}

	public HasEnabled getOKEnabled() {
		return ok;
	}

	public HasVisibility getCancelVisibility() {
		return close;
	}

	public HasClickHandlers getOKClick() {
		return ok;
	}

	public HasClickHandlers getCancelClick() {
		return close;
	}
}
