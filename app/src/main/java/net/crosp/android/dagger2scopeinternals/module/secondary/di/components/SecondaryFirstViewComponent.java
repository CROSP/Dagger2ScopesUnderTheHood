package net.crosp.android.dagger2scopeinternals.module.secondary.di.components;

import net.crosp.android.dagger2scopeinternals.di.scope.PerFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.modules.SecondaryFirstFragmentModule;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryFirstFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {SecondaryFirstFragmentModule.class})
public interface SecondaryFirstViewComponent {
    void inject(SecondaryFirstFragment fragment);
}
