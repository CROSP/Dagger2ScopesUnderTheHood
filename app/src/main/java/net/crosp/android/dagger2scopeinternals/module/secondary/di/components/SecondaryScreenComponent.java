package net.crosp.android.dagger2scopeinternals.module.secondary.di.components;

import net.crosp.android.dagger2scopeinternals.di.scope.PerScreen;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.modules.SecondaryScreenModule;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryActivity;

import dagger.Subcomponent;

@PerScreen
@Subcomponent(modules = {SecondaryScreenModule.class})
public interface SecondaryScreenComponent {
    void inject(SecondaryActivity activity);

    SecondaryFirstViewComponent plusMainFirstViewComponent();

    SecondarySecondViewComponent plusSecondarySecondViewComponent();

}
