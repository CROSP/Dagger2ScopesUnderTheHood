package net.crosp.android.dagger2scopeinternals.module.main.di.components;

import net.crosp.android.dagger2scopeinternals.di.scope.PerFragment;
import net.crosp.android.dagger2scopeinternals.module.main.di.modules.MainSecondFragmentModule;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainSecondFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {MainSecondFragmentModule.class})
public interface MainSecondViewComponent {
    void inject(MainSecondFragment fragment);
}
