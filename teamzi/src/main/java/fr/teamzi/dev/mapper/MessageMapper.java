package fr.teamzi.dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.Message;

public class MessageMapper implements RowMapper<Message> {

   public static final String BASE_SQL = //
           "Select m.messageId, m.userId, m.discussionId, m.content, m.date "
                   + " from Message m ";

   @Override
   public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Integer messageId = rs.getInt("messageId");
	   Integer userId = rs.getInt("userId");
	   Integer discussionId = rs.getInt("discussionId");
	   String content = rs.getString("content");
	   Date date = rs.getDate("date");

       return new Message(messageId, userId, discussionId, content, date);
   }

}
