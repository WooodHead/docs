# mysql commands

  ```
    SHOW PRIVILEGES;

    GRANT ALL PRIVILEGES ON *.* TO 'mysql'@'localhost' WITH GRANT OPTION;
    
    mysqld --skip-grant-tables
    mysql -uroot -p
    mysql> UPDATE mysql.user SET Grant_priv='Y', Super_priv='Y' WHERE User='root';
    mysql> FLUSH PRIVILEGES;
    mysql> GRANT ALL ON *.* TO 'root'@'localhost';
  ```
  
# tools

* [go-sql-driver/mysql](https://github.com/go-sql-driver/mysql)

# issues
 
* [priviledges issue: cannot create table](https://stackoverflow.com/questions/10130296/mysql5-as-root-cant-create-database-or-do-anything-access-denied )
* [[ERROR] Could not open file '/var/log/mysqld.log'](https://unix.stackexchange.com/questions/208328/permission-denied-writing-to-mysql-log)