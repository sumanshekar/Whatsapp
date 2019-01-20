package com.tutorials.hp.swipetabslistview.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tutorials.hp.swipetabslistview.R;
import com.tutorials.hp.swipetabslistview.mData.WList;
import com.tutorials.hp.swipetabslistview.mListView.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 5/9/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class CallFrgament extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.drama_frgament,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.dramaListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getWhatappCall());
        lv.setAdapter(adapter);

        return rootView;
    }


    private ArrayList<WList> getWhatappCall() {
        ArrayList<WList> calls=new ArrayList<>();
        WList wcalls=new WList("Saurav",R.drawable.starwars);
        calls.add(wcalls);

        wcalls=new WList("Mark",R.drawable.rider);
        calls.add(wcalls);

        wcalls=new WList("Watson",R.drawable.ghost);
        calls.add(wcalls);

        return calls;
    }

    @Override
    public String toString() {
        return "Calls";
    }
}
