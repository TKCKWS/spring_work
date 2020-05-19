/* 従業員テーブルのデータ */
INSERT INTO employee (employee_id, employee_name, age)
VALUES(1, '山田太郎', 30);

/* ユーザーマスターテーブルのデータ（ADMIN権限） */
INSERT INTO m_user (user_id, password, user_name, birthday, age, marriage, role)
VALUES('yamada@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '山田太郎', '1990-01-01', 28, false, 'ROLE_ADMIN');

/* ユーザーマスターテーブルのデータ（ADMIN権限） */
INSERT INTO m_user (user_id, password, user_name, birthday, age, marriage, role)
VALUES('ippan@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', '一般次郎', '2000-01-01', 29, false, 'ROLE_GENERAL');
