package fr.teamzi.dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.Document;
import fr.teamzi.dev.model.Template;

public class TemplateMapper implements RowMapper<Template> {

   public static final String BASE_SQL = //
           "Select t.templateId, t.userId, t.templateName, t.data, t.draftState"
                   + " from Template t ";

   @Override
   public Template mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Integer templateId = rs.getInt("templateId");
	   Integer userId = rs.getInt("userId");
	   String templateName = rs.getString("templateName");
       String data = rs.getString("data");
       Boolean draftState = rs.getBoolean("draftState");

       return new Template(templateId,userId,templateName,data,draftState);
   }

}
