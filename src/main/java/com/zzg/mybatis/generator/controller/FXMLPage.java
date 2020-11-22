package com.zzg.mybatis.generator.controller;

/**
 * FXML User Interface enum
 * <p>
 * Created by Owen on 6/20/16.
 */
public enum FXMLPage {

    SINGLE_TABLE_CONFIG("fxml/singleTable.fxml"),
    BATCH_TABLE_CONFIG("fxml/batchTable.fxml"),
    NEW_CONNECTION("fxml/newConnection.fxml"),
    SELECT_TABLE_COLUMN("fxml/selectTableColumn.fxml"),
    GENERATOR_CONFIG("fxml/generatorConfigs.fxml"),
    GENERATOR_BATCH_CONFIG("fxml/generatorBatchConfigs.fxml"),
    ;

    private String fxml;

    FXMLPage(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return this.fxml;
    }


}
