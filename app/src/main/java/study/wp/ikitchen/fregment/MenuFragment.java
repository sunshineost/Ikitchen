package study.wp.ikitchen.fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import study.wp.ikitchen.R;


public class MenuFragment extends Fragment {


    public MenuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_menu,container,false);
        return rootView;
    }


}
