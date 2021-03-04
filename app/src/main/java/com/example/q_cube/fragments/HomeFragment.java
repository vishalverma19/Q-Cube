package com.example.q_cube.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.Model;
import com.example.q_cube.R;
import com.example.q_cube.adapter.AllMenuAdapter;
import com.example.q_cube.adapter.PopularAdapter;
import com.example.q_cube.adapter.RecommendedAdapter;
import com.example.q_cube.model.Allmenu;
import com.example.q_cube.model.FoodData;
import com.example.q_cube.model.Popular;
import com.example.q_cube.model.Recommended;
import com.example.q_cube.retrofit.ApiInterface;
import com.example.q_cube.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;
    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;
    View view;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home, container, false);
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<FoodData>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {

                List<FoodData> foodDataList = response.body();


                getPopularData(foodDataList.get(0).getPopular());
                getRecommendedData(foodDataList.get(0).getRecommended());
                getAllMenu(foodDataList.get(0).getAllmenu());

            }

            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });


        return view;
    }


    public void getPopularData(List<Popular> popularList) {

        popularRecyclerView = (RecyclerView)view.findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(popularList, getActivity());
        RecyclerView.LayoutManager popularLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(popularLayoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = (RecyclerView)view.findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(recommendedList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = (RecyclerView)view.findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(allmenuList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }


}
