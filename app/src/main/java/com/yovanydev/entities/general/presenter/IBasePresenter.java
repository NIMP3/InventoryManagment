package com.yovanydev.entities.general.presenter;

/**
 * @author Edwin Yovany Orbes Villacorte
 * @version 0.0.1
 * Date : 30/09/19
 * Time : 12:10 PM
 **/
public interface IBasePresenter<T> {
    /**
     * Envia un mensaje (No resultados) a la vista
     * @param view : Vista actual
     */
    void showNoResults(T view);

    /**
     * Envia un mensaje (Error del Sistema) a la vista
     * @param view : Vista actual
     * @param type : tipo vista a utilizar para visualizar el error
     */
    void showSystemError(T view, int type);

    /**
     * Envia un mensaje (Error del Servidor) a la vista
     * @param view : Vista actual
     * @param type : tipo de vista a utilizar para visualizar el error
     */
    void showServerError(T view, int type);

    /**
     * Envia un mensaje (Sin conexión a internet) a la vista
     * @param view : Vista actual
     * @param type : Tipo vista a utilizar para visualizar el error
     */
    void showNoNetworkError(T view, int type);

    /**
     * Envia un mensaje (Transación exitosa) a la vista
     * @param view : Vista actual
     * @param type : Tipo vista a utilizar para visualizar el error
     * @param message : Mensaje a visualizar
     */
    void showSuccessfulMessage(T view, String message, int type);
}
