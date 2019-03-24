package com.example.unit4postmortem.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.unit4postmortem.OnFragmentInteractionListener;
import com.example.unit4postmortem.R;
import com.example.unit4postmortem.model.Echinoderm;
import com.example.unit4postmortem.view.EchinodermViewHolder;

import java.util.List;

public class EchinodermAdapter extends RecyclerView.Adapter<EchinodermViewHolder> {
    private List<Echinoderm> echinodermList;
    OnFragmentInteractionListener onFragmentInteractionListener;

    public EchinodermAdapter(List<Echinoderm> echinodermList, OnFragmentInteractionListener onFragmentInteractionListener) {
        this.echinodermList = echinodermList;
        this.onFragmentInteractionListener = onFragmentInteractionListener;
    }

    @NonNull
    @Override
    public EchinodermViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EchinodermViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.echinoderm_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EchinodermViewHolder echinodermViewHolder, int i) {
        echinodermViewHolder.onBind(echinodermList.get(i), onFragmentInteractionListener);
    }

    @Override
    public int getItemCount() {
        return echinodermList.size();
    }
}
