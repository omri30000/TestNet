package com.example.testnet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class QuestionToAnswerAdapter extends ArrayAdapter<QuestionToAnswer> {
    private Context ctx;
    private int questionResourceId;
    private List<QuestionToAnswer> data;

    public QuestionToAnswerAdapter(@NonNull Context context, int resource, @NonNull List<QuestionToAnswer> objects) {
        super(context, resource, objects);

        this.ctx = (TakeExamActivity) context;
        this.questionResourceId = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(this.questionResourceId, null);

        QuestionToAnswer q = this.data.get(position);

        TextView questionTv = v.findViewById(R.id.questionTV);
        questionTv.setText(q.getQuestion());

        RadioButton firstOptionRb = v.findViewById(R.id.option1RB);
        firstOptionRb.setText(q.getFirstOption());

        RadioButton secondOptionRb = v.findViewById(R.id.option2RB);
        secondOptionRb.setText(q.getSecondOption());

        RadioButton thirdOptionRb = v.findViewById(R.id.option3RB);
        thirdOptionRb.setText(q.getThirdOption());

        RadioButton fourthOptionRb = v.findViewById(R.id.option4RB);
        fourthOptionRb.setText(q.getFourthOption());

        return v;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }
}