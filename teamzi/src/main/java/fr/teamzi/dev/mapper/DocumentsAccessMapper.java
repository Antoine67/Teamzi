package fr.teamzi.dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.teamzi.dev.model.DocumentsAccess;

public class DocumentsAccessMapper implements RowMapper<DocumentsAccess> {

   public static final String BASE_SQL =
           "Select da.documentId, da.userId "
                   + " from DocumentsAccess da ";

   @Override
   public DocumentsAccess mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Integer documentId = rs.getInt("documentId");
	   Integer userId = rs.getInt("userId");


       return new DocumentsAccess(documentId, userId);
   }

}
