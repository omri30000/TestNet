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

public class QuestionToViewAdapter extends ArrayAdapter<Question> {
    private Context ctx;
    private int questionResourceId;
    private List<Question> data;

    public QuestionToViewAdapter(@NonNull Context context, int resource, @NonNull List<Question> objects) {
        super(context, resource, objects);

        this.ctx = (CreateExamActivity) context;
        this.questionResourceId = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(this.questionResourceId, null);

        Question q = this.data.get(position);

        TextView questionTv = v.findViewById(R.id.questionToViewTV);
        questionTv.setText(q.getQuestion());

        TextView firstOptionTv = v.findViewById(R.id.answer1TV);
        firstOptionTv.setText(q.getFirstOption());

        TextView secondOptionTv = v.findViewById(R.id.answer2TV);
        secondOptionTv.setText(q.getSecondOption());

        TextView thirdOptionTv = v.findViewById(R.id.answer3TV);
        thirdOptionTv.setText(q.getThirdOption());

        TextView fourthOptionTv = v.findViewById(R.id.answer4TV);
        fourthOptionTv.setText(q.getFourthOption());

        return v;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }
}
