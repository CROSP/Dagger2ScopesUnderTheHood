package net.crosp.android.dagger2scopeinternals.di.contract;


/**
 * The component provide class for DI
 *
 * @param <C> required component class
 */
public interface ProvidesComponent<C> {
    C getComponent();
}
