package com.androidrion.dialogradiobutton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private View parent_view;

    private static final String[] JenisKelamin = new String[]{
            "Male", "Female", "Other"
    };

    private String radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(android.R.id.content);

    }

    public void bukaDialog(View view) {
        int id = view.getId();
        if (id == R.id.buttonDialog) {
            dialogRadioButton();
        }
    }

    private void dialogRadioButton() {
        radioButton = JenisKelamin[0];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Jenis Kelamin Anda");
        builder.setSingleChoiceItems(JenisKelamin, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                radioButton = JenisKelamin[i];
            }
        });
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "Kamu Memilih: " + radioButton, Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.CANCEL, null);
        builder.show();
    }
}
