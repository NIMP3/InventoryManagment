package com.yovanydev.entities.general.view;

public interface IView {
    /**
     * Visualiza un progressbar en el layout actual
     */
    void showProgressbar();

    /**
     * Oculta el progressbar en el layout actual
     */
    void hideProgressbar();

    /**
     * Visualiza un mensaje en el layout actual
     * @param error : Mensaje a visualizar
     * @param typeOfError : Tipo de error a visiualizar
     */
    void showMessage(String error, int typeOfError);

    /**
     * Visualiza un mensaje en un Dialogo
     * @param error : Mensaje a visualizar
     * @param typeOfError : Tipo de error a visualizar
     */
    void showDialogMessage(String error, int typeOfError);

    /**
     * Visualiza un mensaje en un SnackBar
     * @param error : Mensaje a visualizar
     * @param typeOfError : Tipo de error a visualizar
     */
    void showSnackBarMessage(String error, int typeOfError);
}
