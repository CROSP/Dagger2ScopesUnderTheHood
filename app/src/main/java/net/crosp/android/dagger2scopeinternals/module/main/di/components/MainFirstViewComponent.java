package net.crosp.android.dagger2scopeinternals.module.main.di.components;

import net.crosp.android.dagger2scopeinternals.module.main.di.modules.MainFirstFragmentModule;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainFirstFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {MainFirstFragmentModule.class})
public interface MainFirstViewComponent {
    void inject(MainFirstFragment fragment);
}
