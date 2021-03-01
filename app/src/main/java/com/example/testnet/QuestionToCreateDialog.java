package com.example.testnet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ArrayAdapter;

public class QuestionToCreateDialog extends Dialog {

    public QuestionToCreateDialog(final Context ctx) {
        super(ctx);

        this.setContentView(R.layout.question_to_create);
        this.setTitle("Create new question");


    }
}
