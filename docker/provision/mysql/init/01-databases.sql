# create databases
CREATE DATABASE IF NOT EXISTS `delivery`;
CREATE DATABASE IF NOT EXISTS `estoque`;
CREATE DATABASE IF NOT EXISTS `loja`;

# create root user and grant rights
CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';