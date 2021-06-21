package com.example.calculatorwebview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.JavascriptInterface;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;

public class WebAppInterface {
    Context context;
    View view;
    int result = 0;

    public WebAppInterface(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    @JavascriptInterface
    public void addNumbers(int number1, int number2){
        result = number1 + number2;
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void subtractNumbers(int number1, int number2){
        result = number1 - number2;
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void multiplyNumbers(int number1, int number2){
        result = number1 * number2;
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void divideNumbers(int number1, int number2){
        result = number1 / number2;
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void showAlertMessage(String message, String title){
        showAlert(message, title);
    }

    private void showAlert(String message, String title) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(false);

        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
