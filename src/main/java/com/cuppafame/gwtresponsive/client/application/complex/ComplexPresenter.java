package com.cuppafame.gwtresponsive.client.application.complex;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.application.ApplicationPresenter;
import com.cuppafame.gwtresponsive.client.place.NameTokens;
import com.cuppafame.gwtresponsive.client.resources.MainResources;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ComplexPresenter extends Presenter<ComplexPresenter.MyView, ComplexPresenter.MyProxy> {
    public interface MyView extends View {
    }

    private final MainResources res;
    
    @ProxyStandard
    @NameToken(NameTokens.complex)
    public interface MyProxy extends ProxyPlace<ComplexPresenter> {
    }

    @Inject
    ComplexPresenter(EventBus eventBus, MyView view, MyProxy proxy, MainResources res) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        
        this.res = res;
    }
    
    @Override
    protected void onBind() {
    	super.onBind();
    }
}
