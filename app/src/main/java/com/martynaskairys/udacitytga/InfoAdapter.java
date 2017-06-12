package com.martynaskairys.udacitytga;

/**
 * Created by martynaskairys on 07/06/2017.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info>  {

    private int mColorResourceId;


    public InfoAdapter(Context context, ArrayList<Info> infos, int colorResourceId) {
        super(context, 0, infos);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Info currentWord = getItem(position);

        TextView toDoTextView = (TextView) listItemView.findViewById(R.id.to_do_text_view);

        toDoTextView.setText(currentWord.getToDoNameDescription());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getDefaultDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

