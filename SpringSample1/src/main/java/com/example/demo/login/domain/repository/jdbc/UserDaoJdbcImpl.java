package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    // Userテーブルの件数を取得
    @Override
    public int count() throws DataAccessException {

        int count = jdbc.queryForObject("SELECT count(*) FROM m_user", Integer.class);

        return count;
    }

    // Userテーブルにデータを1件insert
    @Override
    public int insertOne(User user) throws DataAccessException {

        // 1件insert
        int insertNumber = jdbc.update("INSERT INTO m_user(user_id,"
                + " password,"
                + " user_name,"
                + " birthday,"
                + " age,"
                + " marriage,"
                + " role)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)",
                user.getUserId(),
                user.getPassword(),
                user.getUserName(),
                user.getBirthday(),
                user.getAge(),
                user.isMarriage(),
                user.getRole());

        // 登録したレコード数を返却
        return insertNumber;
    }

    // Userテーブルのデータを１件取得
    @Override
    public User selectOne(String userId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap(
                "SELECT * FROM m_user" +
                " WHERE user_id = ?",userId
                );
        return this.setUser(map);
    }

    // Userテーブルの全データを取得
    @Override
    public List<User> selectMany() throws DataAccessException {

        // m_userテーブルのデータを全件取得
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * from m_user");

        // 結果返却用の変数
        List<User> userList = new ArrayList<>();

        // 取得したデータを結果返却用のListに格納
        for (Map<String, Object> map : getList) {
            userList.add(this.setUser(map));
        }
        return userList;
    }

    // Userテーブルを１件更新
    @Override
    public int updateOne(User user) throws DataAccessException {
        return 0;
    }

    // Userテーブルを１件削除
    @Override
    public int deleteOne(String userId) throws DataAccessException {
        return 0;
    }

    // SQL取得結果をサーバーにCSVで保存する
    @Override
    public void userCsvOut() throws DataAccessException {

    }

    private User setUser(Map<String,Object> map) {
        // Userインスタンスの生成
        User user = new User();

        user.setUserId((String) map.get("user_id")); // ユーザID
        user.setPassword((String) map.get("password")); // パスワード
        user.setUserName((String) map.get("user_name")); // ユーザ名
        user.setBirthday((Date) map.get("birthday")); //誕生日
        user.setAge((Integer) map.get("age")); // 年齢
        user.setMarriage((Boolean) map.get("marriage")); // 結婚ステータス
        user.setRole((String) map.get("role")); // ロール

        return user;
    }
}
