package study.wp.ikitchen.fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import study.wp.ikitchen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CookBookFragment extends Fragment {


    public CookBookFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View rootView=inflater.inflate(R.layout.fragment_cook_book, container, false);
         return rootView;
    }


}
