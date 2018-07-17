package com.rxjy.rxcompound.des.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;

import uk.co.senab.photoview.PhotoView;

public class WpsImageFragment extends Fragment {


    PhotoView image;
    private String imageUrl;

    public WpsImageFragment() {
        // Required empty public constructor
    }

    public static WpsImageFragment newInstance(String param1) {
        WpsImageFragment fragment = new WpsImageFragment();
        Bundle args = new Bundle();
        args.putString(Constants.IMAGE_URL, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUrl = getArguments().getString(Constants.IMAGE_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wps_image, container, false);
        image = (PhotoView) view.findViewById(R.id.pv_image);
        Glide.with(getContext()).load(imageUrl).into(image);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
