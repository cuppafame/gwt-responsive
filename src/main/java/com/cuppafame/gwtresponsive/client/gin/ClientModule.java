package com.cuppafame.gwtresponsive.client.gin;

import com.cuppafame.gwtresponsive.client.application.ApplicationModule;
import com.cuppafame.gwtresponsive.client.application.about.AboutModule;
import com.cuppafame.gwtresponsive.client.application.legal.LegalModule;
import com.cuppafame.gwtresponsive.client.application.login.LoginModule;
import com.cuppafame.gwtresponsive.client.application.rv.RVModule;
import com.cuppafame.gwtresponsive.client.place.NameTokens;
import com.cuppafame.gwtresponsive.client.resources.MainMessages;
import com.cuppafame.gwtresponsive.client.resources.MainResources;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule());
        install(new ApplicationModule());
        install(new AboutModule());
        install(new LegalModule());
        install(new RVModule());
        install(new LoginModule());

        // DefaultPlaceManager Places
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.home);

		// Resources
		bind(MainResources.class).in(Singleton.class);
        // Load and inject CSS resources
        bind(ResourceLoader.class).asEagerSingleton();

		// Messages
		bind(MainMessages.class).in(Singleton.class);
    }
}
