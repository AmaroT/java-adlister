import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao() throws SQLException {
        Config config = new Config();
        DriverManager.registerDriver(new Driver());

        this.connection = DriverManager.getConnection(
                config.getURL(),
                config.getUser(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
        List<Ad> output = new ArrayList<>();
        String query = "Select * FROM adlister";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                output.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public Long insert(Ad ad) {
        long newCreatedAd = 0;
        String addAdQuery = String.format("INSERT INTO adlister (id, user_id, title, description) VALUES (%d,%d, '%s', '%s')",
                ad.getId(),
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(addAdQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet ks = statement.getGeneratedKeys();
            if (ks.next()) {
                newCreatedAd = ks.getLong(1);
            }
            if (newCreatedAd != 0) {
                ad.setId(newCreatedAd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCreatedAd;
    }
}
