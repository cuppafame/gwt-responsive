package com.cuppafame.gwtresponsive.client.application.about;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.application.ApplicationPresenter;
import com.cuppafame.gwtresponsive.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class AboutPagePresenter extends Presenter<AboutPagePresenter.MyView, AboutPagePresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.about)
    public interface MyProxy extends ProxyPlace<AboutPagePresenter> {
    }

    @Inject
    AboutPagePresenter(EventBus eventBus,
                      MyView view,
                      MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
    }
}
