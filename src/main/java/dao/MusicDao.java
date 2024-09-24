package dao;

import db.DbConnect;
import model.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {

    Connection connection;

    public MusicDao() throws ClassNotFoundException, SQLException{
        connection = DbConnect.getConnection();
    }

    public void addMusic(Music music) {
        try{
            PreparedStatement pst = connection.prepareStatement("insert into music(name, duration) values(?,?)");
            pst.setString(1, music.getName());
            pst.setDouble(2, music.getDuration());
            pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Music> getAllMusics()throws SQLException{
        List<Music> musics = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from music");
            while (rs.next()){
                Music music = new Music();
                music.setID(rs.getInt("ID"));
                music.setName(rs.getString("name"));
                music.setDuration(rs.getDouble("duration"));
                musics.add(music);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return musics;
    }
}
