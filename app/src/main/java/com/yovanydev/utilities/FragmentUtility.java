package com.yovanydev.utilities;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentUtility {

    /**
     * Lanza un fragmento en una actividad determinada
     *
     * @param manager  : Gestiona el fragmento
     * @param fragment : Fragmento a ser inflado
     * @param resource : Referencia a la vista donde sera inflado el fragmento
     */
    public static void launchFragment(FragmentManager manager, Fragment fragment, int resource) {
        manager.beginTransaction()
                .add(resource, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    /**
     * Reemplaza un fragmento en una pila de fragmentos
     *
     * @param manager  : Gestiona el fragmento
     * @param fragment : Fragmento a ser inflado
     * @param resource : Referencia a la vista donce sera inflado el fragmento
     */
    public static void replaceFragment(FragmentManager manager, Fragment fragment, int resource) {
        manager.beginTransaction()
                .replace(resource, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public static void replaceFragment(FragmentManager manager, Fragment fragment, int resource, String flag) {
        manager.beginTransaction()
                .replace(resource, fragment, flag)
                .addToBackStack(flag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
