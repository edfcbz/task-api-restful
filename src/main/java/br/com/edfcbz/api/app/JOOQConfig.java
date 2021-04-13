package br.com.edfcbz.api.app;

import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Configuration;
import org.jooq.util.jaxb.Database;
import org.jooq.util.jaxb.Generator;
import org.jooq.util.jaxb.Jdbc;
import org.jooq.util.jaxb.Target;

public class JOOQConfig {

    public static void main(String[] args) throws Exception {
        
        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl("jdbc:mysql://localhost:3306/apirest?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC")
                        .withUser("root")
                        .withPassword("admin123"))
                .withGenerator(new Generator()
                        .withName("org.jooq.util.DefaultGenerator")
                        .withDatabase(new Database()
                                .withName("org.jooq.util.mysql.MySQLDatabase")
                                .withInputSchema("apirest")
                                .withIncludes(".*"))
                        .withTarget(new Target()
                                .withPackageName("br.com.edfcbz.api.generatedclasses")
                                .withDirectory("D:/eclipse-workspace/api/src/main/java")));
        GenerationTool.main(configuration);
    }
}