package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.TemplateMapper;
import fr.teamzi.dev.model.Template;


 
@Repository
@Transactional
public class TemplateDAO extends JdbcDaoSupport {
 
    @Autowired
    public TemplateDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    private int getNextId() {
        String sql = "Select max(t.templateId) from Template t";
 
        Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    
    public Template findTemplate(Integer templateId) {
        String sql = TemplateMapper.BASE_SQL //
                + " where t.templateId = ?";
 
        Object[] params = new Object[] { templateId };
         
        TemplateMapper mapper = new TemplateMapper();
 
        Template usr = this.getJdbcTemplate().queryForObject(sql, params, mapper);
        return usr;
    }
    
    public boolean isOwnerTemplate(Integer templateId, Integer userId) {
    	String sql = "SELECT 1 FROM Template t "
                + " WHERE t.templateId = ? AND t.userId = ?";
 
        Object[] params = new Object[] { templateId, userId };
         
       
        Integer t = null ;
        try {
        	t = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
        } catch (EmptyResultDataAccessException e) {t = null;}
        
        return (t != null) ? true : false;
    }
    
   
    
    
 
    public int addTemplate(Integer userId, String templateName, String data) {
        String sql = "Insert into Template (templateId,userId,templateName,data,draftState) "//
                + " values (?,?,?,?,?) ";
        int templateId = this.getNextId() + 1;
        Object[] params = new Object[] { templateId, userId,templateName, data, 1 };
        this.getJdbcTemplate().update(sql, params);
        return templateId;
    }


	public void updateTemplate(int templateId, String data) {
		String sql = "UPDATE Template " + 
				"SET data = ? " + 
				"WHERE templateId = ?";
		Object[] params = new Object[] { data, templateId };
		this.getJdbcTemplate().update(sql, params);
	}

	public List<Template> getAllTemplatesFromUserId(Integer userId) {
		String sql = TemplateMapper.BASE_SQL +
				"WHERE t.userId=?";
		 
        Object[] params = new Object[] {userId};
        TemplateMapper mapper = new TemplateMapper();
 
        List<Template> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
		
	}

	
 
}
