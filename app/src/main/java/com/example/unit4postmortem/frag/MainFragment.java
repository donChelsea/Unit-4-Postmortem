package com.example.unit4postmortem.frag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit4postmortem.R;
import com.example.unit4postmortem.model.Echinoderm;
import com.squareup.picasso.Picasso;

import static com.example.unit4postmortem.MainActivity.ANIMAL_IMAGE;
import static com.example.unit4postmortem.MainActivity.ANIMAL_NAME;
import static com.example.unit4postmortem.MainActivity.ANIMAL_WIKI;


public class MainFragment extends Fragment {
    private String animalName;
    private String animalImage;
    private String animalWiki;
    private TextView nameTv;
    private Button button;
    private ImageView imageIv;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
       return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(ANIMAL_NAME);
            animalImage = getArguments().getString(ANIMAL_IMAGE);
            animalWiki = getArguments().getString(ANIMAL_WIKI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTv = view.findViewById(R.id.frag_name_textview);
        button = view.findViewById(R.id.frag_button);
        imageIv = view.findViewById(R.id.animal_image);

        nameTv.setText(animalName);
        Picasso.get().load(animalImage).into(imageIv);
        button.setOnClickListener(v ->
                v.getContext().startActivity(new Intent(v.getContext(), Intent.ACTION_VIEW(Uri.parse(animalWiki))));
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
