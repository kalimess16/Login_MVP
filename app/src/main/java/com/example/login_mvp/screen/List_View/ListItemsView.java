package com.example.login_mvp.screen.List_View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login_mvp.R;
import com.example.login_mvp.data.model.Personal;
import com.example.login_mvp.data.source.local.DBManager;
import com.example.login_mvp.data.source.local.LocalDataSource;
import com.example.login_mvp.screen.List_View.ListAdapter.ListAdapter;
import java.util.List;

public class ListItemsView extends AppCompatActivity implements IListViewContract.View {

    private EditText mName,mPhone,mAdd,mgender;
    private IListViewContract.Presenter mPresenter;
    private ListView mListView;
    private ListAdapter mListAdapter;
    private List<Personal> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);
        initView();

        // setAdapter
        mList = mPresenter.addPersonals();
        setMyAdapter();
    }

    private void initView() {
        mListView = findViewById(R.id.list_view);
        mName = findViewById(R.id.text_name);
        mPhone = findViewById(R.id.text_phone);
        mAdd = findViewById(R.id.text_add);
        mgender = findViewById(R.id.text_gender);
        // khoi tao luong
        mPresenter = new ListItemsPresenter(new LocalDataSource(new DBManager(getApplicationContext())),this,this);
    }
    // show list view

    private void setMyAdapter() {
        if (mListAdapter == null)
            mListAdapter = new ListAdapter(this,R.layout.items_lists,mList);
        mListView.setAdapter(mListAdapter);
    }

    @Override
    public void clearText() {
        mName.setText("");
        mPhone.setText("");
        mAdd.setText("");
        mgender.setText("");
    }

    @Override
    public void onResult() {

    }

    public void onClick(View view) {
        int getId = view.getId();
        String name = mName.getText().toString();
        String phone = mName.getText().toString();
        String add = mName.getText().toString();
        String gender = mName.getText().toString();
        mPresenter.createPersonal(name,phone,add,gender);
        if (getId == R.id.button_save){
            // insert
            mPresenter.insertData();
            mPresenter.clear();
        }else {
            // reload
            mPresenter.reload(mListAdapter);
        }
    }



}
