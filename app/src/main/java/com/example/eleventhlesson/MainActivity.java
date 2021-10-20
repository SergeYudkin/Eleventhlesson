package com.example.eleventhlesson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button alertDialog1 = findViewById(R.id.alertDialog1);
        alertDialog1.setOnClickListener(clickListenerDialog1);

        Button alertDialog3 = findViewById(R.id.alertDialog3);
        alertDialog3.setOnClickListener(clickListenerDialog3);

        Button alertDialogList = findViewById(R.id.alertDialogList);
        alertDialogList.setOnClickListener(clickListenerDialogList);

        Button alertDialogListSingle = findViewById(R.id.alertDialogListSingle);
        alertDialogListSingle.setOnClickListener(clickListenerDialogListSingle);

        Button alertDialogListMulti = findViewById(R.id.alertDialogListMulti);
        alertDialogListMulti.setOnClickListener(clickListenerDialogListMulti);

    }

    private final View.OnClickListener clickListenerDialog1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setMessage(R.string.message)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private final View.OnClickListener clickListenerDialog3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setMessage(R.string.message)
                    .setPositiveButton(R.string.yes,dialogListener)
                    .setNegativeButton(R.string.no,dialogListener)
                     .setNeutralButton(R.string.neutral,dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


    private final View.OnClickListener clickListenerDialogList = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] variants = getResources().getStringArray(R.array.variants);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setItems(variants,dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private int chosenSingle = -1;
    private final View.OnClickListener clickListenerDialogListSingle = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] variants = getResources().getStringArray(R.array.variants);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setSingleChoiceItems(variants, chosenSingle, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            chosenSingle = i;

                        }
                    })
                    .setPositiveButton(R.string.yes, dialogListener);

            android.app.AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


    private boolean[] chosenMulti = {false,false,false};
    private final View.OnClickListener clickListenerDialogListMulti = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] variants = getResources().getStringArray(R.array.variants);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setMultiChoiceItems(variants, chosenMulti, new DialogInterface.OnMultiChoiceClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int i, boolean b) {
                                chosenMulti[i] = b;
                        }
                    })
                    .setPositiveButton(R.string.yes, dialogListener);

            android.app.AlertDialog dialog = builder.create();
            dialog.show();
        }
    };




    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

               if (i == AlertDialog.BUTTON_NEGATIVE);
               if (i == AlertDialog.BUTTON_POSITIVE);
               if (i == AlertDialog.BUTTON_NEUTRAL);

           }
       };



}
