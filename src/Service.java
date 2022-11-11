import java.sql.*;
import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the option below");
            System.out.println("1 :Insert");
            System.out.println("2 :View");
            System.out.println("3 :Search");
            System.out.println("4 :Update");
            System.out.println("5 :Delete");

            System.out.println("6 :exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:

                    System.out.println("Add customer details...");
                    System.out.println("Enter the customer code");
                    int code = sc.nextInt();
                    System.out.println("Enter the  name:--");
                    String name = sc.next();
                    System.out.println("Enter the Address:--");
                    String address = sc.next();
                    System.out.println("Enter the phone:--");
                    int phone = sc.nextInt();
                    System.out.println("Enter the email:--");
                    String email = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="INSERT INTO `consumer`(`code`, `name`, `address`, `phno`, `email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,code);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,phone);
                        stmt.setString(5,email);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfuly.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;



                case 2:
                    System.out.println("View all customer");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql = "SELECT `code`, `name`, `address`, `phno`, `email` FROM `consumer`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            code = rs.getInt("code");
                            name = rs.getString("name");
                            address = rs.getString("address");
                            phone = rs.getInt("phno");
                            email = rs.getString("email");
                            System.out.println("code = "+code);
                            System.out.println("name = "+name);
                            System.out.println("address = "+address);
                            System.out.println("phone number = "+phone);
                            System.out.println("Email id = "+email+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }


                    break;



                case 3:
                    System.out.println("Search");
                    System.out.println("1.search using name");
                    System.out.println("2.search using phone number");
                    System.out.println("3.search using code");
                    int choice1 = sc.nextInt();
                    switch (choice1)
                    {
                        case 1:
                            System.out.println("enter the name:-");
                            name = sc.next();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `name`='"+name+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;

                        case 2:
                            System.out.println("enter phone number for search :-");
                            phone = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `phno`='"+phone+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Enter customer code for search");
                            code = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `code`='"+code+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                    }

                    break;

                case 4:
                    System.out.println("Update");

                    System.out.println("Add customer details...");
                    System.out.println("Enter the customer code");
                    code=sc.nextInt();
                    System.out.println("Enter the  name to be updated:--");
                    name=sc.next();
                    System.out.println("Enter the Address to be updated:--");
                    address=sc.next();
                    System.out.println("Enter the phone to be updated:--");
                    phone=sc.nextInt();
                    System.out.println("Enter the email to be updated:--");
                    email=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="UPDATE `consumer` SET `name`='"+name+"',`address`='"+address+"',`phno`='"+String.valueOf(phone)+"',`email`='"+email+"' WHERE `code`="+String.valueOf(code);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Data updated  successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;


                case 5:
                    System.out.println("Delete the consumer");
                    System.out.println("enter the code");

                    code = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                        String sql = "DELETE FROM `consumer` WHERE `code`='"+code+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;




                case 6:
                    System.exit(0);
            }
        }
    }
}
