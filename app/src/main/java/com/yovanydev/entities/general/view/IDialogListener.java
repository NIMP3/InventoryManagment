package com.yovanydev.entities.general.view;

/**
 * @author Edwin Yovany Orbes Villacorte
 * @version 0.0.1
 * Date : 30/09/19
 * Time : 03:31 PM
 **/

public interface IDialogListener {
    /**
     * Procesa la opción OK del dialogo lanzado
     */
    void setOK();

    /**
     * Procesa la opción OK del dialogo lanzado con una respuesta del mismo
     * @param result : Resultado o respuesta emitido
     */
    void setOK(String result);

    /**
     * Procesa la opción CANCELAR del dialogo lanzado
     */
    void setCancel();
}
