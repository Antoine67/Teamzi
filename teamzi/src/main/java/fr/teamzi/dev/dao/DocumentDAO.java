package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.DocumentMapper;
import fr.teamzi.dev.model.Document;


 
@Repository
@Transactional
public class DocumentDAO extends JdbcDaoSupport {
 
    @Autowired
    public DocumentDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    private int getNextId() {
        String sql = "Select max(d.documentId) from Document d";
 
        Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    
    public Document findDocument(int documentId) {
        String sql = DocumentMapper.BASE_SQL //
                + " where d.documentId = ?";
 
        Object[] params = new Object[] { documentId };
         
        DocumentMapper mapper = new DocumentMapper();
 
        Document usr = this.getJdbcTemplate().queryForObject(sql, params, mapper);
        return usr;
    }
    
   
    
    
 
    public void addDocument(Integer creatorId, String documentName, Integer templateId, String data) {
        String sql = "Insert into Document (documentId,creatorId,documentName,templateId,data) "//
                + " values (?,?,?,?,?) ";
        int documentId = this.getNextId() + 1;
        Object[] params = new Object[] { documentId, creatorId,documentName, templateId, data };
        this.getJdbcTemplate().update(sql, params);
    }

	public List<Document> getDocuments() {
		 String sql = DocumentMapper.BASE_SQL;
		 
	        Object[] params = new Object[] {};
	        DocumentMapper mapper = new DocumentMapper();
	 
	        List<Document> list = this.getJdbcTemplate().query(sql, params, mapper);
	        return list;
	}

	public void updateDocument(int documentId, String data) {
		String sql = "UPDATE Document " + 
				"SET data = ? " + 
				"WHERE documentId = ?";
		Object[] params = new Object[] { data, documentId };
		this.getJdbcTemplate().update(sql, params);
	}

	public List<Document> getAllDocsFromUserId(Integer userId) {
		String sql = DocumentMapper.BASE_SQL +
				"NATURAL JOIN DocumentsAccess da "+
				"WHERE da.userId=?";
		 
        Object[] params = new Object[] {userId};
        DocumentMapper mapper = new DocumentMapper();
 
        List<Document> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
		
	}

	
 
}
