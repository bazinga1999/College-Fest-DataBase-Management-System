package fest3;

import java.sql.*;

class Participants{
    String id ;String name;String event;
    String status;String college;String contact;
    }

public class DBconnection {
    private static final String username = "prutyay";
    private static final String password = "password";
    private static final String CONN = "jdbc:mysql://localhost/dbms_project";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,username,password);
    }

    public static String AddData(String[] input,String[] attributes,String table){
        int num_attributes = 0;
        String output = "";
        for(int i =1;i<attributes.length;i++){
            if(!attributes[i].equals("NULL")){
                num_attributes++;
            }
        }

        String query = "INSERT INTO " + table + " VALUES (";
        int count = 0;
        for(int i = 0;i<num_attributes;i++){
            if(!input[i].equals("")){
                if(count ==0){
                    query += "'"+input[i]+"'";
                    count+=1;
                }else{
                    query += ","+"'"+input[i]+"'";

                }
            }else{

                return ("Wrong Input : Fill in all the entities");
            }
        }
        query+=")";

        System.out.println(query);

        try(
                Connection con = DBconnection.getConnection();
                Statement stmt = con.createStatement();

        ) {
            stmt.executeUpdate(query);
            System.out.println("successfully inserted");
            output = "successfully inserted";

        } catch (SQLException e) {
            output = "Wrong input";
            e.printStackTrace();
        }


        return output;
    }

    public static String UpdateData(String[] input_condition,String[] input_update,String[] attributes,String table){
        int num_attributes = 0;

        for(int i =1;i<attributes.length;i++){
            if(!attributes[i].equals("NULL")){
                num_attributes++;
            }
        }

        String query = "UPDATE " + table + " SET ";
        String output = "";
        int count = 0;


        for(int i = 0;i<num_attributes;i++){
            if(!input_update[i].equals("")){
                if(count == 0){
                    query += attributes[i+1] + " = '" + input_update[i] + "'";
                    count += 1;
                }else{
                    query += ", " + attributes[i+1] + " = '" + input_update[i] + "'";

                }
            }
        }
        count = 0;
        for(int i = 0;i<num_attributes;i++){
            if(!input_condition[i].equals("")) {

                if (count == 0) {
                    query += " WHERE " + attributes[i+1] + " = '" + input_condition[i] + "'";
                    count += 1;
                } else {
                    query += " AND " + attributes[i+1] + " = '" + input_condition[i] + "'";
                }
            }
        }
        System.out.println(query);

        try(
                Connection con = DBconnection.getConnection();
                Statement stmt = con.createStatement();

        ) {
            stmt.executeUpdate(query);
            output += "successfully updated";

        } catch (SQLException e) {
            output = "Wrong input";
//            e.printStackTrace();
        }

        return output;
    }

    public static String SelectData(String[] input,String[] attributes,String table){
        int num_attributes = 0;

        for(int i =1;i<attributes.length;i++){
            if(!attributes[i].equals("NULL")){
                num_attributes++;
            }
        }

        String query = "SELECT * FROM " + table ;
        String output = "";
        int count = 0;
        System.out.println(query);

        for(int i = 0;i<num_attributes;i++){
            if(!input[i].equals("")){
                if(count == 0){
                    query += " WHERE " + attributes[i+1] + " = " + "'" + input[i] + "'";
                    count+=1;
                }
                else{
                    count+=1;
                    query += " AND " + attributes[i+1] + " = " + "'" + input[i] + "'";
                }
            }
        }
        System.out.println(query);
        try(
                Connection con = DBconnection.getConnection();
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(query);

        ) {

            int[] spaces = new int[num_attributes];
            for(int i = 0;i<num_attributes;i++){
                if(attributes[i+1].length()>spaces[i]){
                    spaces[i] = attributes[i+1].length();
                }
            }
            while(rs.next()){

                for(int i = 0;i<num_attributes;i++){

                    if(rs.getString(attributes[i+1]).length()>spaces[i]){
                        spaces[i] = rs.getString(attributes[i+1]).length();
                    }
                }

            }
            int total = 0;
            for(int i = 0;i<num_attributes;i++){
                System.out.print( spaces[i] + " ");
                total+=spaces[i];
            }
            rs.beforeFirst();
            for(int i = 0;i<num_attributes;i++){
                output+=attributes[i+1] + "";
                for(int j=0;j<spaces[i]-attributes[i+1].length();j++){
                    output+=" ";
                }
                output+="|";
            }
            output+="\n";
            for(int i = 0;i<total;i++){
                output+="-";
            }

            output+="\n";
            while(rs.next()){

                for(int i = 0;i<num_attributes;i++){
                    output+= rs.getString(attributes[i+1]) + "";
                    for(int j=0;j<spaces[i]-rs.getString(attributes[i+1]).length();j++){
                        output+=" ";
                    }
                    output+="|";
                }
                output+="\n";

            }


        } catch (SQLException e) {
            output = "Wrong input";
//            System.out.println("Wrong input,or database not conncted");
            e.printStackTrace();
        }

        return output;
    }

    public static String DeleteData(String[] input,String[] attributes,String table){

        int num_attributes = 0;

        for(int i =1;i<attributes.length;i++){
            if(!attributes[i].equals("NULL")){
                num_attributes++;
            }
        }

        String query = "DELETE FROM " + table ;
        String output = "";
        int count = 0;

        for(int i = 0;i<num_attributes;i++){
            if(!input[i].equals("")){
                if(count == 0){
                    query += " WHERE " + attributes[i+1] + " = " + "'" + input[i] + "'";
                    count+=1;
                }
                else{
                    count+=1;
                    query += " AND " + attributes[i+1] + " = " + "'" + input[i] + "'";
                }
            }
        }
        System.out.println(query);
        try(
                Connection con = DBconnection.getConnection();
                Statement stmt = con.createStatement();

        ) {
            stmt.executeUpdate(query);
            output = "successfully deleted";
            System.out.println("successfully deleted");

        } catch (SQLException e) {
            output = "Wrong input";
//            e.printStackTrace();
        }

//        INSERT INTO `events`(`name`, `dept`, `status`, `prizes`, `location`) VALUES ('test','def',1500,'toffee','online')
        return output;
    }

}
