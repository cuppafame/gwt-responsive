package com.cuppafame.gwtresponsive.client.application.legal;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.application.ApplicationPresenter;
import com.cuppafame.gwtresponsive.client.place.NameTokens;
import com.cuppafame.gwtresponsive.client.resources.MainResources;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class LegalPagePresenter extends Presenter<LegalPagePresenter.MyView, LegalPagePresenter.MyProxy> {
    public interface MyView extends View {
    	HasHTML getHtmlPanel();
    }

    private final MainResources res;
    
    @ProxyStandard
    @NameToken(NameTokens.legal)
    public interface MyProxy extends ProxyPlace<LegalPagePresenter> {
    }

    @Inject
    LegalPagePresenter(EventBus eventBus, MyView view, MyProxy proxy, MainResources res) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        
        this.res = res;
    }
    
    @Override
    protected void onBind() {
    	super.onBind();
    	
    	getView().getHtmlPanel().setHTML( res.termsOfUse().getText() );
    }
}
