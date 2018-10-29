package net.crosp.android.dagger2scopeinternals.module.secondary.di.components;

import net.crosp.android.dagger2scopeinternals.di.scope.PerFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.modules.SecondarySecondFragmentModule;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondarySecondFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {SecondarySecondFragmentModule.class})
public interface SecondarySecondViewComponent {
    void inject(SecondarySecondFragment fragment);
}
