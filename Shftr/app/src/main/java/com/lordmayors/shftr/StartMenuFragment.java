package com.lordmayors.shftr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andy on 5/07/15.
 */
public class StartMenuFragment extends Fragment implements View.OnClickListener {
    private MapsActivity startListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.start_menu, container, false);

        v.findViewById(R.id.button).setOnClickListener( this );

        return v;
    }

    public void setStartListener(MapsActivity startListener) {
        this.startListener = startListener;
    }

    @Override
    public void onClick(View v)
    {
        startListener.start();
    }
}
