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
public class ChatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.crime_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.crimeListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getWhatsappChat());
        lv.setAdapter(adapter);


        return rootView;
    }

    private ArrayList<WList> getWhatsappChat() {
        //COLECTION OF CRIME MOVIES
        ArrayList<WList> chat=new ArrayList<>();

        //SINGLE MOVIE
        WList Wchat=new WList("Suman",R.drawable.red);

        //ADD ITR TO COLLECTION
        chat.add(Wchat);

        Wchat=new WList("Sushmitha",R.drawable.breaking);
        chat.add(Wchat);

        Wchat=new WList("Minku",R.drawable.crisis);
        chat.add(Wchat);

        Wchat=new WList("Simba",R.drawable.blacklist);
        chat.add(Wchat);

        Wchat=new WList("Chilli",R.drawable.meninblack);
        chat.add(Wchat);

        return chat;
    }

    @Override
    public String toString() {
        String title="Chats";
        return title;
    }
}
