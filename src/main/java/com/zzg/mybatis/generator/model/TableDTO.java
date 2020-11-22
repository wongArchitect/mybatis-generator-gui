package com.zzg.mybatis.generator.model;

public class TableDTO {
    private String tableName;
    private String domainObjectName;
    private String tablePK;

    private String[] tableNames;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDomainObjectName() {
        return domainObjectName;
    }

    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName;
    }

    public String getTablePK() {
        return tablePK;
    }

    public void setTablePK(String tablePK) {
        this.tablePK = tablePK;
    }

    public String[] getTableNames() {
        return tableNames;
    }

    public void setTableNames(String[] tableNames) {
        this.tableNames = tableNames;
    }
}
