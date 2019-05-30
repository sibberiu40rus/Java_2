package Lesson_2;

import java.sql.*;

//Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
//        id – порядковый номер записи, первичный ключ;
//        prodid – уникальный номер товара;
//        title – название товара;
//        cost – стоимость.
//
//        При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
//        id_товара 1 товар1 10
//        id_товара 2 товар2 20
//        id_товара 3 товар3 30
//        id_товара 10000 товар10000 100000

public class Lesson_2_hw {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement preparedStatement;

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //createTable();
        addInTable();
        disconnect();
    }

    /**
     * Метод создания таблиы(В методе main после создания таблицы пришлось закоментировать т.к не получилось реализовать IF NOT EXISTS)
     * @throws SQLException
     */

    public static void createTable() throws SQLException {
        try {
            stmt.executeUpdate("CREATE TABLE  product (product_id INTEGER PRIMARY KEY \n" +
                    ", prodid  INT NOT NULL UNIQUE \n" +
                    ", title   VARCHAR(40) NOT NULL\n" +
                    ", cost  INT \n)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавления товаров в таблицу
     * @throws SQLException
     */


    public static void addInTable() throws SQLException  {

        //предварительное очищение таблицы(согласно условию)
        stmt.executeUpdate("DELETE FROM product");

        connection.setAutoCommit(false);

        preparedStatement = connection.prepareStatement("INSERT INTO product (prodid, title, cost)\n " + "VALUES (?,?,?)");

        for (int i = 0; i < 10000; i++) {
            preparedStatement.setInt(1,(i+1));
            preparedStatement.setString(2,"товар: " + (i+1));
            preparedStatement.setInt(3,(i*10));
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        connection.setAutoCommit(true);

    }
}
