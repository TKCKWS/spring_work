package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // リポジトリークラスのアノテーション リポジトリクラスでデータ操作
public class HelloRepository {

    @Autowired // JDBC接続のためのインスタンス作成
    private JdbcTemplate jdbcTemplate;

    /**
     * DBから従業員IDをキーに1件検索
     *
     * @param id 従業員ID
     * @return DB検索結果Map
     */
    public Map<String, Object> findOne(int id) {
        String query = "SELECT "
                + " employee_id,"
                + " employee_name,"
                + " age, "
                + "FROM employee "
                + "WHERE employee_id=?";

        // 検索実行
        Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
        return employee;
    }
}
