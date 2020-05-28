package mnstate.example.projecttwo;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {
    ImageView smile;
    Button fromfrag;


    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_picture, container, false);




        smile=view.findViewById(R.id.smileblue);
        fromfrag=view.findViewById(R.id.infragbtn);
        final MediaPlayer mp=MediaPlayer.create(getActivity(),R.raw.haveaniceday);
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

            }
        });

        fromfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.framelayout,new DetailsFragment());
                fr.commit();


            }
        });
        return view;


    }

}
