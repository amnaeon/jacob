package com.example.stus.jacob.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stus.jacob.R;
import com.example.stus.jacob.models.RecomendationModel;

import java.util.List;

/**
 * Created by root on 14.05.17.
 */

public class WordSelectorAdapter extends RecyclerView.Adapter<WordSelectorAdapter.ViewHolder> {

    private List<RecomendationModel> items;
    private Button saveButton;

    public WordSelectorAdapter(List<RecomendationModel> items) {
        this.items = items;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.word_selector_list_item, parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecomendationModel recomendationModel = items.get(position);
        holder.wordSelectorText.setText(recomendationModel.word);
        holder.layoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = holder.wordSelectorCheck;
                checkBox.setChecked(!checkBox.isChecked());

                if(saveButton != null && !saveButton.isEnabled()) {
                    saveButton.setEnabled(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox wordSelectorCheck;
        TextView wordSelectorText;
        LinearLayout layoutContainer;
        ViewHolder(View itemView) {
            super(itemView);
            wordSelectorCheck = (CheckBox) itemView.findViewById(R.id.wordSelectorCheck);
            wordSelectorText = (TextView) itemView.findViewById(R.id.wordSelectorText);
            layoutContainer = (LinearLayout) itemView.findViewById(R.id.layoutContainer);
        }
    }
}
