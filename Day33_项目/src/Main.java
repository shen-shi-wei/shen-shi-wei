import com.lanou.bookstore.user.util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by travelround on 17/4/18.
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {

//            ps = connection.prepareStatement("SELECT *FROM hw_user");
            ps = connection.prepareStatement("SELECT *FROM user");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getObject(1));
                System.out.println(resultSet.getObject(2));
                System.out.println(resultSet.getObject(3));
//                System.out.println(resultSet.getObject(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.release(resultSet, ps, connection);
        }

    }

}
