package com.example.unit4postmortem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.unit4postmortem.controller.EchinodermAdapter;
import com.example.unit4postmortem.frag.MainFragment;
import com.example.unit4postmortem.model.Echinoderm;
import com.example.unit4postmortem.network.EchinodermsService;
import com.example.unit4postmortem.network.RetrofitSingleton;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    public static final String ANIMAL_NAME = "animal name";
    public static final String ANIMAL_IMAGE = "animal image";
    public static final String ANIMAL_WIKI = "animal wiki";
    public static final java.lang.String TAG = "MainActivity";
    OnFragmentInteractionListener fragmentInteractionListener;
    Disposable retrofit;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = RetrofitSingleton.getInstance()
                .create(EchinodermsService.class)
                .getEchinodermList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(echinodermList -> {
                    List<Echinoderm> echinoderms = echinodermList.getEchinodermList();
                    recyclerView = findViewById(R.id.recycler_view);
                    recyclerView.setAdapter(new EchinodermAdapter(echinoderms, fragmentInteractionListener));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }, throwable -> Log.d(TAG, "onFailure: " + throwable.getMessage()));
    }

    @Override
    public void onFragmentInteraction(Echinoderm echinoderm, String website) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL_NAME, echinoderm.getAnimal());
        args.putString(ANIMAL_IMAGE, echinoderm.getImage());
        args.putString(ANIMAL_WIKI, website);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack("first")
                .commit();
    }
}
