package com.codflix.backend.features.profil;

import com.codflix.backend.core.Database;
import com.codflix.backend.features.user.UserDao;
import com.codflix.backend.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfilDao {
    UserDao userDao = new UserDao();


    /***
     * function that allows to update the users's email in the database
     * @param email new email chose by the user
     * @param id of the user in database
     */

    public void updateEmail(String email,int id) {
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE user SET email =? WHERE id=?");
            st.setString(1, email);
            st.setInt(2, id);
            st.execute();
            System.out.println("update mail ok");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * function that allows to update the users's password in the database
     * @param password new password chose by the user
     * @param id of the user in database
     */
        public void updatePassword(String password,int id){
            Connection connection = Database.get().getConnection();
            try {
                PreparedStatement st = connection.prepareStatement("UPDATE user SET password =? WHERE id=?");
                st.setString(1, password);
                st.setInt(2, id);
                st.execute();
                System.out.println("mot de passe update");

        }
            catch (SQLException e) {
                e.printStackTrace();
            }

    }

    }



