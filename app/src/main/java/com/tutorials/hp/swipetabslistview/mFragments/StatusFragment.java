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
public class StatusFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.documentary_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.docsListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getWhatsappStatus());

        lv.setAdapter(adapter);
        return rootView;
    }
    private ArrayList<WList> getWhatsappStatus() {
        ArrayList<WList> status=new ArrayList<>();
        WList wstatus=new WList("Dhoni",R.drawable.shuttlecarrier);
        status.add(wstatus);

        wstatus=new WList("Rama",R.drawable.fruits);
        status.add(wstatus);

        wstatus=new WList("Swara",R.drawable.space);
        status.add(wstatus);

        wstatus=new WList("Shah",R.drawable.thrones);
        status.add(wstatus);

        wstatus=new WList("Sree ",R.drawable.moderncity);
        status.add(wstatus);

        return status;
    }

    @Override
    public String toString() {
        return "Status";
    }
}
