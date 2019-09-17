package com.example.login_mvp.screen.List_View;

import android.content.Context;
import android.widget.Toast;
import com.example.login_mvp.data.model.Personal;
import com.example.login_mvp.data.source.local.LocalDataSource;
import com.example.login_mvp.screen.List_View.ListAdapter.ListAdapter;
import java.util.ArrayList;
import java.util.List;

public class ListItemsPresenter implements IListViewContract.Presenter {

    private IListViewContract.View mView;
    private LocalDataSource mDataSource;
    private List<Personal> mPersonals;
    private Context mContext;

    ListItemsPresenter(LocalDataSource local, IListViewContract.View view,Context context) {
        mView = view;
        mDataSource = local;
        mContext = context;
    }

    @Override
    public void clear() {
        mView.clearText();
    }

    @Override
    public void insertData() {
        if (mPersonal!=null){
            mDataSource.addPersonal(mPersonal);
        }
        Toast.makeText(mContext, "Success Insert", Toast.LENGTH_SHORT).show();
    }

    private Personal mPersonal;
    @Override
    public Personal createPersonal(String name, String phone, String add, String gen) {
        mPersonal = new Personal(name,phone,add,gen);
        return mPersonal;
    }

    @Override
    public void setView(IListViewContract.View view) {
        mView = view;
    }
    @Override
    public List<Personal> addPersonals(){
        mPersonals =  mDataSource.getAllPersonal();
       return mPersonals;
    }

    @Override
    public void reload(ListAdapter listAdapter) {
        mPersonals.clear();
        List<Personal> list = mDataSource.getAllPersonal();
        mPersonals.addAll(list);
        listAdapter.notifyDataSetChanged();
        Toast.makeText(mContext, "Done", Toast.LENGTH_SHORT).show();
    }
}
