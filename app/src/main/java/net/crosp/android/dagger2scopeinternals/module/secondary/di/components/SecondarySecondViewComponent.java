package net.crosp.android.dagger2scopeinternals.module.secondary.di.components;

import net.crosp.android.dagger2scopeinternals.module.secondary.di.modules.SecondarySecondFragmentModule;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondarySecondFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {SecondarySecondFragmentModule.class})
public interface SecondarySecondViewComponent {
    void inject(SecondarySecondFragment fragment);
}
