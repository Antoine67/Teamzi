package fr.teamzi.dev.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.TeamziUser;

public class TeamziUserMapper implements RowMapper<TeamziUser> {

   public static final String BASE_SQL = //
           "Select u.userId, u.userName, u.userEmail "
                   + " from TeamziUser u ";

   @Override
   public TeamziUser mapRow(ResultSet rs, int rowNum) throws SQLException {
       Integer userId = rs.getInt("userId");
       String userName = rs.getString("userName");
       String userEmail = rs.getString("userEmail");

       return new TeamziUser(userId, userName, userEmail);
   }

}
