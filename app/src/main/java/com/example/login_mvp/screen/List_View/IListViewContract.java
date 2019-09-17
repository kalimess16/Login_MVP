package com.example.login_mvp.screen.List_View;

import com.example.login_mvp.data.model.Personal;
import com.example.login_mvp.screen.List_View.ListAdapter.ListAdapter;
import com.example.login_mvp.utils.BasePresenter;
import java.util.List;

public interface IListViewContract {
    /**
     * View
     */

    interface View {
        void clearText();
        void onResult();
    }

    /**
     * Presenter
     */
    interface Presenter extends BasePresenter<View> {
        void clear();
        void insertData();
        Personal createPersonal(String name,String phone,String add,String gen);
        List<Personal> addPersonals();
        void reload(ListAdapter listAdapter);
    }
}
