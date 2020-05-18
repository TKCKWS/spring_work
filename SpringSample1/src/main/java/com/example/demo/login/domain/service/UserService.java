package com.example.demo.login.domain.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService {

    @Autowired
    @Qualifier("UserDaoNamedJdbcImpl")
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

    /**
     * CSV出力用メソッド
     * @throws DataAccessException
     */
    public void userCsvOut() throws DataAccessException {
        // CSV出力
        dao.userCsvOut();
    }

    /**
     * サーバーに保存されているファイルを取得して、byte配列に変換する.
     */
    public byte[] getFile(String fileName) throws IOException {

        // ファイルシステム（デフォルト）の取得
        FileSystem fs = FileSystems.getDefault();

        // ファイル取得
        Path p = fs.getPath(fileName);

        // ファイルをbyte配列に変換
        byte[] bytes = Files.readAllBytes(p);

        return bytes;
    }
}
