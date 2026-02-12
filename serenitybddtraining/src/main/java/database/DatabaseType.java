package database;

public enum DatabaseType {

    SQL_SERVER("org.hibernate.dialect.SQLServerDialect"),
    MYSQL("org.hibernate.dialect.MySQLDialect"),
    ORACLE("org.hibernate.dialect.OracleDialect");

    private final String dialect;

    public String getDialect() {
        return dialect;
    }

    DatabaseType(String dialect) {
        this.dialect = dialect;
    }
}
