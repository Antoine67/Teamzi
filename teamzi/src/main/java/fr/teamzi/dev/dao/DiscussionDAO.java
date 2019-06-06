package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.DocumentMapper;
import fr.teamzi.dev.mapper.DiscussionMapper;
import fr.teamzi.dev.model.Document;
import fr.teamzi.dev.model.Discussion;


 
@Repository
@Transactional
public class DiscussionDAO extends JdbcDaoSupport {
 
    @Autowired
    public DiscussionDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    
   


	
 
}
