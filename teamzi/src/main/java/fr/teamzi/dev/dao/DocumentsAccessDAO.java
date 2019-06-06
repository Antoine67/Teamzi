package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.DocumentMapper;
import fr.teamzi.dev.mapper.DocumentsAccessMapper;
import fr.teamzi.dev.model.Document;
import fr.teamzi.dev.model.DocumentsAccess;


 
@Repository
@Transactional
public class DocumentsAccessDAO extends JdbcDaoSupport {
 
    @Autowired
    public DocumentsAccessDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    
    public boolean hasAccess(int documentId, int userId) {
        String sql = "SELECT 1 FROM DocumentsAccess da "
                + " WHERE da.documentId = ? AND da.userId = ?";
 
        Object[] params = new Object[] { documentId, userId };
         
        //DocumentsAccessMapper mapper = new DocumentsAccessMapper();
        Integer da = null ;
        try {
        	da = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
        } catch (EmptyResultDataAccessException e) {da = null;}
        
        return (da != null) ? true : false;
    }
  
    public void addAccess(Integer documentId, Integer userId) {
        String sql = "Insert into DocumentsAccess (documentId,userId) "//
                + " values (?,?) ";
        Object[] params = new Object[] { documentId, userId};
        this.getJdbcTemplate().update(sql, params);
    }


	
 
}
