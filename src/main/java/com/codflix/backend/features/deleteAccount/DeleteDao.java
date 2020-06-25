package com.codflix.backend.features.deleteAccount;

import com.codflix.backend.core.Database;
import com.codflix.backend.features.profil.ProfilDao;
import com.codflix.backend.features.user.UserDao;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
    UserDao userDao = new UserDao();
    ProfilDao profilDao = new ProfilDao();

    /***
     * function that allows to delete account in the database
     * @param id of the user in the database
     */
    public void deleteAccount(int id) {
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE id=?;");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

