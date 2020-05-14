package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    /**
     * insert用メソッド
     */
    public boolean insert(User user) {

        // insert実行
        int insertNumber = dao.insertOne(user);

        // 判定用変数
        boolean result = false;

        if (insertNumber > 0) {
            // insert成功
            result = true;
        }
        return result;
    }

    /**
     * カウント用メソッド
     */
    public int count() {
        return dao.count();
    }

    /**
     * 全件取得用メソッド
     */
    public List<User> selectMany() {
        // 全件取得
        return dao.selectMany();
    }

    /**
     * 1件取得用メソッド
     */
    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    /**
     * 1件更新用メソッド
     */
    public boolean updateOne(User user) {

        // 判定用変数
        boolean result = false;

        // 1件更新
        int updateNumber = dao.updateOne(user);

        if (updateNumber > 0) {
            // update成功
            result = true;
        }

        return result;
    }

    /**
     * 1件削除用メソッド
     */
    public boolean deleteOne(String userId) {
        // 1件削除
        int deleteNumber = dao.deleteOne(userId);

        // 判定用変数
        boolean result = false;

        if (deleteNumber > 0) {
            // delete成功
            result = true;
        }
        return result;
    }
}
