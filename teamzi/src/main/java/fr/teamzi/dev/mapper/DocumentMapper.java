package fr.teamzi.dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.Document;

public class DocumentMapper implements RowMapper<Document> {

   public static final String BASE_SQL = //
           "Select d.documentId, d.creatorId, d.documentName, d.templateId, d.data "
                   + " from Document d ";

   @Override
   public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Integer documentId = rs.getInt("documentId");
	   Integer creatorId = rs.getInt("creatorId");
	   String documentName = rs.getString("documentName");
       Integer templateId = rs.getInt("templateId");
       String data = rs.getString("data");

       return new Document(documentId, creatorId, documentName, templateId, data);
   }

}
