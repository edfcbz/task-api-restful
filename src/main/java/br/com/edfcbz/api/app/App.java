package br.com.edfcbz.api.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DSL;

import br.com.edfcbz.api.bean.Country;
import br.com.edfcbz.api.generatedclasses.Tables;
import br.com.edfcbz.api.generatedclasses.tables.records.CountryRecord;

public class App {
	static Connection conn;
	public static void main(String[] args) {
		String userName = "root";
		String password = "admin123";
		String url = "jdbc:mysql://localhost:3306/apirest?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			System.out.println("Conectou");
			
			
			//INSERINDO NA TABELA
			CountryRecord pais  = new CountryRecord();
			pais.setName("CAMBALACHO 2");
			create.executeInsert(pais);
			
			//REFERENCIA https://www.jooq.org/doc/3.13/manual/sql-building/sql-statements/insert-statement/insert-values/
			//INSERINDO NA TABELA
			create.insertInto(Tables.COUNTRY, Tables.COUNTRY.NAME )
			      .values("TESTANDO COM NOVA API")
			      .execute();
			
			      
			//INSERINDO MULTIPLOS VALORES
			create.insertInto(Tables.COUNTRY, Tables.COUNTRY.NAME)
			      .values("PARAGUAY DE NOVO")
			      .values("CHILE DE NOVO")
			      .values("COLOMBIA DE NOVO")
			      .execute();        
			

			//DELETANDO REGISTROS
			//https://www.jooq.org/doc/3.13/manual/sql-building/sql-statements/delete-statement/
			int i = create.delete(Tables.COUNTRY)
		      .where(Tables.COUNTRY.NAME.eq("CHILE"))
		      .or(Tables.COUNTRY.NAME.eq("COLOMBIA"))
			  .execute();
			System.out.println("RESULTADO DO UPDATE: "+i);
		      
			i = create.delete(Tables.COUNTRY)
				      .where(Tables.COUNTRY.NAME.eq("CAMBALACHO 2"))
					  .execute();
					System.out.println("RESULTADO DO UPDATE: "+i);
		
			//UPDATE
			create.update(Tables.COUNTRY)
		      .set(Tables.COUNTRY.NAME, "PAIS DE ALICE")
		      .where(Tables.COUNTRY.NAME.eq("CAMBALACHO"))
		      .execute();			
			
			SelectJoinStep<Record> countries =  create.select().from(Tables.COUNTRY);
			
			//List<Country> lista = Arrays.asList
			
			
            Result<Record> result = create.select().from(Tables.COUNTRY).fetch();
            System.out.println("TODOS OS REGISTROS \n");
			for (Record r : result) {
				r.get(Tables.COUNTRY.NAME);
				System.out.println("Nome: "+r.get(Tables.COUNTRY.NAME));
			}  		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}
	

	
}
