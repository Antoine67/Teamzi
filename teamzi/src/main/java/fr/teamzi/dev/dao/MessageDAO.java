package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.MessageMapper;
import fr.teamzi.dev.model.Message;


 
@Repository
@Transactional
public class MessageDAO extends JdbcDaoSupport {
 
    @Autowired
    public MessageDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    private int getNextId() {
        String sql = "Select max(m.messageId) from Message m";
 
        Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    
    public Message findMessage(int messageId) {
        String sql = MessageMapper.BASE_SQL //
                + " where m.messageId = ?";
 
        Object[] params = new Object[] { messageId };
         
        MessageMapper mapper = new MessageMapper();
 
        Message msg = this.getJdbcTemplate().queryForObject(sql, params, mapper);
        return msg;
    }
    
   
    
    
 
    public void addMessage(Integer userId, Integer discussionId, String content) {
        String sql = "Insert into Message (messageId,userId,discussionId,content) "//
                + " values (?,?,?,?) ";
        int messageId = this.getNextId() + 1;
        Object[] params = new Object[] { messageId, userId,discussionId, content};
        this.getJdbcTemplate().update(sql, params);
    }

	
	/*
	//TODO Message modification after creation ? Future update?
	public void updateMessage(int messageId, String data) {
		String sql = "UPDATE Message " + 
				"SET data = ? " + 
				"WHERE messageId = ?";
		Object[] params = new Object[] { data, messageId };
		this.getJdbcTemplate().update(sql, params);
	}*/


	
 
}
