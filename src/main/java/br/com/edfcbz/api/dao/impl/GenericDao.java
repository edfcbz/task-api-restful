package br.com.edfcbz.api.dao.impl;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import br.com.edfcbz.api.connection.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class  GenericDao{

    public static DSLContext getDbContext() throws Throwable {
        return DSL.using(ConnectionFactory.getConnection(), SQLDialect.MYSQL);
    }       
}
