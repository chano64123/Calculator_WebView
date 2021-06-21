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
    double result = 0;

    public WebAppInterface(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    @JavascriptInterface
    public void addNumbers(String number1, String number2){
        result = Double.parseDouble(number1) + Double.parseDouble(number2);
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void subtractNumbers(String number1, String number2){
        result = Double.parseDouble(number1) - Double.parseDouble(number2);
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void multiplyNumbers(String number1, String number2){
        result = Double.parseDouble(number1) * Double.parseDouble(number2);
        showAlert(String.valueOf(result),"Resultado");
    }

    @JavascriptInterface
    public void divideNumbers(String number1, String number2){
        result = Double.parseDouble(number1) / Double.parseDouble(number2);
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

        alert.setPositiveButton(R.string.ok, (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
