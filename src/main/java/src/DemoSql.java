package src;//package COM.JUNIOR.menu;

// import src.menu.MainMenu;

import src.model.Animal;
import src.model.AnimalComparatorByAge;
import src.model.AnimalTree;
import src.model.ObjIO;
import src.presenter.Presenter;
import src.view.ConsoleUI;
import src.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DemoSql {
    /*
    private static final String PERSON_QUERY;
    static{
        InputStream str = null;
        try{
            str = DemoSql.class.getResourceAsStream("query.sql");
            PERSON_QUERY = IOUtils.toString(str, "UTF-8"); // IOUtils.toString(str);
        }catch(IOException e){
            throw new IllegalStateException("Failed to read SQL query", e);
        }finally{
            IOUtils.closeQuitely(str);
        }
    }
    */

    public static void TestMVP(){
        View view = new ConsoleUI();
        System.out.println("\n\n\n\n\nHumanTree. TestMVP () :\n");

        ObjIO serialize = new ObjIO();
        AnimalComparatorByAge sortAge =  new AnimalComparatorByAge();

        AnimalTree<Animal> newAnimalTree = new AnimalTree<>(); //???
        new Presenter(view, newAnimalTree, serialize, sortAge);
        view.start();
    }

    public static void main(String[] args) throws SQLException {
       //  System.out.println(String.format("PERSON_QUERY  : %s", PERSON_QUERY));

        System.out.println("Hello");

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/sql.properties")){
            //
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }   // O:\_Archive\gb\JD\mySql\src\main\resources\sql.properties

        Connection connection = DriverManager.getConnection
                //  ("jdbc:mysql://localhost:3306/Друзья_человека", "root", "gbmysqlivd@64");
              (properties.getProperty("database.url"),
              properties.getProperty("database.login"),
              properties.getProperty("database.pass"));

        Statement statementUSE = connection.createStatement();
        statementUSE.executeUpdate(
                "USE Друзья_человека; SET CHARACTER SET 'utf8'; SET collation_connection='utf8_general_ci';");

        Statement statement = connection.createStatement();

        String[] arr = {"id", "вид"};
        String str = String.join(", ", arr);
        String str0 ;  String str1 ;
        str0 = "select " + str +" from ЖИВОТНЫЕ limit 15";  // select "id", "вид" from Друзья_человека.ЖИВОТНЫЕ limit 15
        // str0 = "select " + str +" from Друзья_человека.ЖИВОТНЫЕ limit 15";  // select "id", "вид" from Друзья_человека.ЖИВОТНЫЕ limit 15

        ResultSet resultSet = statement.executeQuery(str0);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("\n\nHello: " + str0);

        {
            int columnCount = resultSetMetaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++)
            {
                String name = resultSetMetaData.getColumnName(column);
                String className = resultSetMetaData.getColumnClassName(column);
                String typeName = resultSetMetaData.getColumnTypeName(column);
                int type = resultSetMetaData.getColumnType(column);

                System.out.println(name + "\t" + className + "\t" + typeName + "\t" + type);
            }

        }

        System.out.println("\n\nHello: " + str0);


        while (resultSet.next()){
            StringBuilder str1Builder = new StringBuilder(" ");
            for (String s : arr) {
                str1Builder.append(" ").append(resultSet.getString(s));
            }
            str1 = str1Builder.toString();

            System.out.println(str1);
            // System.out.println( resultSet.getString("id")+ " " + resultSet.getString( "вид"));
            /*
                       System.out.println(resultSet.getString(1) + " " +
                            resultSet.getString(2) + " "
                           // +   resultSet.getString(3) + " " +
                      //      resultSet.getString(4) + " " +
                        //    resultSet.getString(5)
                    );
            */


        }


        ResultSet resultSet1 = statement.executeQuery("select id, name, district from world.city limit 15");
        System.out.println("""
                Hello select id, name, district from world.city limit 15""");

        while (resultSet1.next()){
            System.out.println(
                    resultSet1.getInt("id") + " " +
                            resultSet1.getString("name") + " " +
                            resultSet1.getString("district")
            );
        }

        resultSet.close();
        resultSet1.close();
        statement.close();
        connection.close();  // close resultSet.close();  resultSet1.close();  statement.close();

        TestLoadSQL();
        TestMenu();

        TestMVP();
    }

    public static void TestMenu(){
     //  var mainMenu = new MainMenu();
      //  mainMenu.display();
    }

    public static void TestLoadSQL(){



    }

}
