package com.edge.fragmentactivitycallback;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CallbackFramgent extends Fragment implements Callback {

    TextView textView;
    MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
            activity.setCallback(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        textView = view.findViewById(R.id.text_view);
    }

    @Override
    public void dataCallback(String data) {
        textView.setText(data);
    }
}
