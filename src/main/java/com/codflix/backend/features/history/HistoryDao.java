package com.codflix.backend.features.history;

import com.codflix.backend.core.Database;
import com.codflix.backend.models.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {

    public List<History> getStreamsHistoryForUser(int userId) {
        List<History> histories = new ArrayList<>();
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM history WHERE user_id=?");

            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                History history = mapToStreamHistory(rs);
                histories.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    private History mapToStreamHistory(ResultSet rs) throws SQLException {
        return new History(
                rs.getInt(1), // id
                rs.getInt(2), // user_id
                rs.getInt(3), // stream_id
                rs.getString(4), // startDate
                rs.getString(5), // endDate
                rs.getInt(6) // watchDuration
        );
    }

    /***
     * function that allows to add informations in the table history of the database
     * @param user_id
     * @param media_id
     * @param start_date
     * @param finish_date
     * @param watch_duration
     * @return a boolean
     */
    public boolean addToHistory(int user_id,int media_id,String start_date,String finish_date, int watch_duration){

        String s = "INSERT INTO `history` (`id`, `user_id`, `media_id`, `start_date`, `finish_date`, `watch_duration`) VALUES (NULL, '"+ user_id +"', '"+ media_id +"', '"+ start_date +"', '"+ finish_date +"', '"+ watch_duration +"');";
        System.out.println(s);
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(s);
            st.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /***
     * function that allows to delete all history in database
     * @return a boolean
     */
    public boolean deleteAllHistory(){
        String s = "DELETE FROM `history`";
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(s);
            st.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /***
     * function that allows to delete one element of history in database
     * @param id
     * @return
     */
    public boolean deleteElementOfHistory(int id){
        String s = "DELETE FROM `history` WHERE id=?";
        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(s);
            st.setInt(1,id);
            st.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    }

