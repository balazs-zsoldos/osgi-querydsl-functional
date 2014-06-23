osgi-querydsl-support
=====================

Component that make it possible to access the database by implementing functional interfaces.

SQLExceptions are caughed by QuerydslSupport, translated with the help of the Querydsl configuration and rethrown.

## Usage with Java 7

    return querydslSupport.execute(new QuerydslCallable<Long>() {
    
         @Override
         public Long call(Connection connection, Configuration configuration) throws SQLException {
            QResource qResource = new QResource("qResource");
            SQLInsertClause insertClause = new SQLInsertClause(connection, configuration, qResource);
            return insertClause.executeWithKey(qResource.resourceId);
        }
    });


## Usage with Java 8

    return querydslSupport.execute((connection, configuration) {
        QResource qResource = new QResource("qResource");
        SQLInsertClause insertClause = new SQLInsertClause(connection, configuration, qResource);
        return insertClause.executeWithKey(qResource.resourceId);
    });