package com.example.unit4postmortem.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit4postmortem.OnFragmentInteractionListener;
import com.example.unit4postmortem.R;
import com.example.unit4postmortem.model.Echinoderm;
import com.squareup.picasso.Picasso;

public class EchinodermViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTv;
    private ImageView animalIv;


    public EchinodermViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name_textview);
        animalIv = itemView.findViewById(R.id.main_image_view);
    }

    public void onBind(final Echinoderm echinoderm, final OnFragmentInteractionListener onFragmentInteractionListener) {
        nameTv.setText(echinoderm.getAnimal());
        nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentInteractionListener.onFragmentInteraction(echinoderm);
            }
        });
        Picasso.get().load(echinoderm.getImage()).into(animalIv);
    }
}
