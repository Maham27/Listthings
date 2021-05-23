package com.example.listthings;

import android.app.Application;

import java.util.ArrayList;

public class listdata extends Application {
    public static ArrayList<listinfo> l;

    @Override
    public void onCreate() {
        super.onCreate();
        l=new ArrayList<>();
        //l.add(new listinfo("study","mad","27-0-2011","2:22:30","red"));



    }


}
