# employee-seat-system
專案名稱：
員工座位管理系統

技術：
Vue 3
Spring Boot
MySQL
Maven

功能：
1. 顯示樓層座位
2. 員工座位指派
3. 清除座位
4. 顯示座位狀態

資料庫：
Employee
SeatingChart

資料庫環境說明

安全性：
1. SQL Injection 防護(JPA)
2. XSS 防護(Vue Escape)

Stored Procedure：
AssignSeat

本專案開發環境：

* MySQL 8.x
* Database：employee_seat_system
* Port：3306

如需於其他環境執行，請依實際環境修改：

backend/src/main/resources/application.properties

中的資料庫連線設定。

資料表建立與測試資料請參考：

DB/ddl.sql
DB/dml.sql
DB/sp.sql
