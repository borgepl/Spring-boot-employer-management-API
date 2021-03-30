## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Database
CREATE DATABASE empl;

#Create database service accounts
CREATE USER 'emp_test_user'@'localhost' IDENTIFIED BY 'testpwd';
CREATE USER 'emp_test_user'@'%' IDENTIFIED BY 'testpwd';

GRANT SELECT ON empl.* to 'emp_test_user'@'localhost';
GRANT INSERT ON empl.* to 'emp_test_user'@'localhost';
GRANT DELETE ON empl.* to 'emp_test_user'@'localhost';
GRANT UPDATE ON empl.* to 'emp_test_user'@'localhost';

GRANT SELECT ON empl.* to 'emp_test_user'@'%';
GRANT INSERT ON empl.* to 'emp_test_user'@'%';
GRANT DELETE ON empl.* to 'emp_test_user'@'%';
GRANT UPDATE ON empl.* to 'emp_test_user'@'%';

