package com.example.login_mvp.data.source;

import com.example.login_mvp.data.model.Personal;
import java.util.List;

public interface DataSource {
    /**
     * Local
     */
    interface Local {
        List<Personal> getAllPersonal();

        void addPersonal(Personal personal);
    }
}
