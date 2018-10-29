package net.crosp.android.dagger2scopeinternals.module.main.di.components;

import net.crosp.android.dagger2scopeinternals.di.scope.PerScreen;
import net.crosp.android.dagger2scopeinternals.module.main.di.modules.MainScreenModule;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainActivity;

import dagger.Subcomponent;

@PerScreen
@Subcomponent(modules = {MainScreenModule.class})
public interface MainScreenComponent {
    void inject(MainActivity activity);

    MainFirstViewComponent plusMainFirstViewComponent();

    MainSecondViewComponent plusMainSecondViewComponent();

}
