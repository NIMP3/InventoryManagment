package com.yovanydev.utilities;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.airbnb.lottie.LottieAnimationView;
import com.yovanydev.R;
import com.yovanydev.entities.general.view.IDialogListener;

import java.util.HashMap;

public class DialogUtility {

    public static final int ANIMATION_ERROR = 0;
    public static final int ANIMATION_CHECK = 1;
    public static final int ANIMATION_WARNING = 2;
    public static final int ANIMATION_QUESTION = 3;
    public static final int ANIMATION_INFO = 4;
    public static final int ANIMATION_LOAD = 5;
    public static final int BASIC_MESSAGE_TIME = 2000;

    public static final String ANIMATION = "ANIMATION";
    public static final String TEXT = "text";

    /**
     * Actualiza los datos de un dialogo
     * @param dialog : Dialogo a ser actualizado
     * @param activity : Actividad que contiene al  Dialogo
     * @param content : Contenido a ser actualizado en el dialogo
     * @param animationType : Tipo  de animación a ser actualizada en el dialogo
     */
    public  static void updateDialog(AlertDialog dialog, Activity activity, String content, int animationType) {
        TextView tvTitleMessage = dialog.findViewById(R.id.tvTitleMessage);
        TextView tvContentMessage = dialog.findViewById(R.id.tvContentMessage);
        LottieAnimationView lottieAnimation = dialog.findViewById(R.id.lottieAnimation);

        HashMap<String, Integer> values = getAnimationDialog(animationType);

        lottieAnimation.setAnimation(values.get(ANIMATION));
        lottieAnimation.setSpeed(0.7f);

        tvTitleMessage.setText(activity.getString(values.get(TEXT)));
        tvContentMessage.setText(content);
    }

    /**
     * Genera un Dialogo sencillo
     * @param activity : Actividad que contiene al Dialogo
     * @param content : Contenido a ser visualizado en el Dialogo
     * @param animationType : Tipo de animación a ser visualizada
     * @return : AlertDialog - Nueva Instancia para manejar el mensaje
     */
    public static AlertDialog createMessageDialog(Activity activity, String content, int animationType) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_message, null);

        TextView tvTitleMessage = v.findViewById(R.id.tvTitleMessage);
        TextView tvContentMessage = v.findViewById(R.id.tvContentMessage);
        LottieAnimationView lottieAnimation = v.findViewById(R.id.lottieAnimation);

        HashMap<String, Integer> values = getAnimationDialog(animationType);

        lottieAnimation.setAnimation(values.get(ANIMATION));
        lottieAnimation.setSpeed(0.7f);

        tvTitleMessage.setText(activity.getString(values.get(TEXT)));
        tvContentMessage.setText(content);

        builder.setCancelable(false);
        builder.setView(v);
        return builder.create();
    }

    /**
     * Genera un Dialogo con opciones para aceptar o cancelar el mensaje
     * @param activity : Actividad que contiene a el mensaje
     * @param content : Contenido del mensaje a ser visualizado
     * @param animationType :  Tipo de animación a ser visualizada
     * @return : AlertDialog - Nueva Instancia para manejar el mensaje
     */
    public static AlertDialog createMessageDialogOptions(Activity activity, String content, int animationType, final IDialogListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_message, null);

        TextView tvTitleMessage = v.findViewById(R.id.tvTitleMessage);
        TextView tvContentMessage = v.findViewById(R.id.tvContentMessage);
        LottieAnimationView lottieAnimation = v.findViewById(R.id.lottieAnimation);

        HashMap<String, Integer> values = getAnimationDialog(animationType);

        lottieAnimation.setAnimation(values.get(ANIMATION));
        lottieAnimation.setSpeed(0.7f);

        tvTitleMessage.setText(activity.getString(values.get(TEXT)));
        tvContentMessage.setText(content);

        builder.setPositiveButton(activity.getString(R.string.text_ok_dialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog alertDialog = (AlertDialog) dialog;
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
                listener.setOK();
            }
        });

        builder.setNegativeButton(activity.getString(R.string.text_cancel_dialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.setCancel();
            }
        });

        builder.setView(v);
        return builder.create();
    }

    /**
     * Genera un Dialogo con multiples opciones para elegir
     * @param activity : Actividad que contiene al mensaje
     * @param items : Listado de opciones elegibles
     * @param title : Titulo del Dialogo
     * @param position : posición elegida
     * @param listener : Escucha para el manejo de los eventos dentro del dialogo
     * @return AlertDialog : Nueva Instancia para manejar el mensaje
     */
    public static AlertDialog createMessageDialogItems(Activity activity, CharSequence[] items, String title, int position, final IDialogListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final int[] currentPos = {position, position};

        builder.setTitle(title)
                .setSingleChoiceItems(items, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        currentPos[1] = currentPos[0];
                        currentPos[0] = which;
                    }
                })
                .setPositiveButton(activity.getString(R.string.text_ok_dialog), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (currentPos[0] == currentPos[1]) listener.setOK("-1");
                        else listener.setOK(String.valueOf(currentPos[0]));
                    }
                });

        return builder.create();
    }

    /**
     * Genera un diccionario de recursos dependiendo del tipo de Dialogo que se desee visualizar
     * @param animationType : Tipo de animación a visualizar
     * @return : Diccionario de recursos
     */
    static HashMap<String, Integer> getAnimationDialog(int animationType) {
        HashMap<String, Integer> values = new HashMap<>();

        switch (animationType) {
            case ANIMATION_ERROR:
                values.put(ANIMATION, R.raw.error);
                values.put(TEXT, R.string.text_error);
                break;
            case ANIMATION_CHECK:
                values.put(ANIMATION, R.raw.check);
                values.put(TEXT, R.string.text_info);
                break;
            case ANIMATION_WARNING:
                values.put(ANIMATION, R.raw.warning);
                values.put(TEXT, R.string.text_warning);
                break;
            case ANIMATION_QUESTION:
                values.put(ANIMATION, R.raw.question);
                values.put(TEXT, R.string.text_question);
                break;
            case ANIMATION_LOAD:
                values.put(ANIMATION, R.raw.loader);
                values.put(TEXT, R.string.text_load);
                break;
            default:
                values.put(ANIMATION, R.raw.info);
                values.put(TEXT, R.string.text_info);
                break;
        }

        return values;
    }
}
