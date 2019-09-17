package com.example.login_mvp.data.source.local;

import com.example.login_mvp.data.model.Personal;
import com.example.login_mvp.data.source.DataSource;
import java.util.List;

public class LocalDataSource implements DataSource.Local {

    private DBManager mDBManager;

    public LocalDataSource(DBManager dbManager) {
        mDBManager = dbManager;
    }

    @Override
    public List<Personal> getAllPersonal() {
       return mDBManager.getAllPersonal();
    }

    @Override
    public void addPersonal(Personal personal) {
        mDBManager.addPersonal(personal);
    }
}
