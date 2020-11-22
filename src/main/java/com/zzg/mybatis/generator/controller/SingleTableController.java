package com.zzg.mybatis.generator.controller;

import com.zzg.mybatis.generator.model.DatabaseConfig;
import com.zzg.mybatis.generator.model.UITableColumnVO;
import com.zzg.mybatis.generator.util.ConfigHelper;
import com.zzg.mybatis.generator.util.DbUtil;
import com.zzg.mybatis.generator.view.AlertUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SingleTableController extends BaseFXController {

    private static final Logger _LOG = LoggerFactory.getLogger(SingleTableController.class);

    @FXML
    protected TextField tableNameField;
    @FXML
    protected TextField domainObjectNameField;
    @FXML
    protected TextField tablePKFiled;
    @FXML
    protected TextField tableNamesFiled;


    private String tableName;
    private String domainObjectName;
    private String tablePK;


    // Current selected databaseConfig
    private DatabaseConfig selectedDatabaseConfig;

    protected MainUIController tabTableControlerA;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        tableNameField.setText(cellData -> cellData.getValue().firstNameProperty());
//        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    void setMainUIController(MainUIController controller) {
        this.tabTableControlerA = controller;
    }

//
//    void setMainUIBatchController(MainUIBatchController controller) {
//        this.mainUIBatchController = controller;
//        super.setDialogStage(mainUIBatchController.getDialogStage());
//    }

    @FXML
    public void openTableColumnCustomizationPage() {
        if (tableName == null) {
            AlertUtil.showWarnAlert("请先在左侧选择数据库表");
            return;
        }
        SelectTableColumnController controller = (SelectTableColumnController) loadFXMLPage("定制列", FXMLPage.SELECT_TABLE_COLUMN, true);
        controller.setSingleTableController(this);
        try {
            // If select same schema and another table, update table data
            if (!tableName.equals(controller.getTableName())) {
                List<UITableColumnVO> tableColumns = DbUtil.getTableColumns(selectedDatabaseConfig, tableName);
                controller.setColumnList(FXCollections.observableList(tableColumns));
                controller.setTableName(tableName);
            }
            controller.showDialogStage();
        } catch (Exception e) {
            _LOG.error(e.getMessage(), e);
            AlertUtil.showErrorAlert(e.getMessage());
        }
    }

}
