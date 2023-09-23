package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.modelo.Pessoa;

public class DaoPessoa {
	
	public void inclui(Pessoa p) throws Exception{
		String ins =" Insert into pessoa(nome, genero, nascimento) values(?,?,?)";
		String insConhe = "INSERT into conhecimento values (?,?,?)";
		try(Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(ins, new String[] {"id"});
						PreparedStatement pstmt2 = con.prepareStatement(insConhe)){
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getGenero());
			pstmt.setDate(3, Date.valueOf(p.getNascimento()));
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				p.setId(rs.getLong(1));
			}
			
			for(String idioma: p.getIdiomas()) {
				pstmt2.setLong(1, p.getId());
				pstmt2.setString(2, idioma);
				pstmt2.setString(3, "Idioma");
				pstmt2.addBatch();
			}
			
			for(String s: p.getSkills()) {
				pstmt2.setLong(1, p.getId());
				pstmt2.setString(2, s);
				pstmt2.setString(3, "TI");
				pstmt2.addBatch();
			}
			pstmt2.executeBatch();
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
