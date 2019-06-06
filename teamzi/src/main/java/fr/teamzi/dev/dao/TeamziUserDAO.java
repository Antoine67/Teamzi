package fr.teamzi.dev.dao;

import java.util.List;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.teamzi.dev.mapper.TeamziUserMapper;
import fr.teamzi.dev.model.TeamziUser;
 
@Repository
@Transactional
public class TeamziUserDAO extends JdbcDaoSupport {
 
    @Autowired
    public TeamziUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    private int getNextId() {
        String sql = "Select max(u.userId) from TeamziUser u";
 
        Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    
    public TeamziUser findUser(int userId) {
        String sql = TeamziUserMapper.BASE_SQL //
                + " where u.userId = ?";
 
        Object[] params = new Object[] { userId };
         
        TeamziUserMapper mapper = new TeamziUserMapper();
        TeamziUser usr;
        try { usr = this.getJdbcTemplate().queryForObject(sql, params, mapper); }
        catch(EmptyResultDataAccessException e) { return null;}
        return usr;
    }
    
    public TeamziUser findUser(String email) {
    	String sql = TeamziUserMapper.BASE_SQL //
                + " where u.userEmail = ?";
 
        Object[] params = new Object[] { email };
         
        TeamziUserMapper mapper = new TeamziUserMapper();
        TeamziUser usr;
        try { usr = this.getJdbcTemplate().queryForObject(sql, params, mapper);}
        catch(EmptyResultDataAccessException e) { return null;}
        return usr;
	}
    
    
 
    public Integer addUser(String userName, String userEmail) {
        String sql = "Insert into TeamziUser (userId,userName,userEmail) "//
                + " values (?,?,?) ";
        int userId = this.getNextId() + 1;
        Object[] params = new Object[] { userId, userName, userEmail };
        this.getJdbcTemplate().update(sql, params);
        return userId;
    }

	public List<TeamziUser> getUsers() {
		 String sql = TeamziUserMapper.BASE_SQL;
		 
	        Object[] params = new Object[] {};
	        TeamziUserMapper mapper = new TeamziUserMapper();
	 
	        List<TeamziUser> list = this.getJdbcTemplate().query(sql, params, mapper);
	        return list;
	}

	
 
}
