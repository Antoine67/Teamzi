package fr.teamzi.dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.Discussion;

public class DiscussionMapper implements RowMapper<Discussion> {

   public static final String BASE_SQL = //
           "Select di.discussionId, di.documentId "
                   + " from Discussion di ";

   @Override
   public Discussion mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Integer discussionId = rs.getInt("discussionId");
	   Integer documentId = rs.getInt("documentId");

       return new Discussion(discussionId, documentId);
   }

}
