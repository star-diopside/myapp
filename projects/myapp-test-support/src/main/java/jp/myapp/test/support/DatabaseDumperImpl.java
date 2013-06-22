package jp.myapp.test.support;

import java.sql.SQLException;

import javax.sql.DataSource;

import jp.myapp.exception.SystemException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * データベースダンプに関する処理を行うユーティリティクラス
 */
public class DatabaseDumperImpl implements DatabaseDumper {

    /** トランザクションマネージャ */
    private PlatformTransactionManager transactionManager;

    /** データソース */
    private DataSource dataSource;

    /**
     * トランザクションマネージャを設定する。
     * 
     * @param transactionManager トランザクションマネージャ
     */
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * データソースを設定する。
     * 
     * @param dataSource データソース
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDataSet setUp(final IDataSet setupDataSet) {

        return new TransactionTemplate(transactionManager, new DefaultTransactionDefinition(
                TransactionDefinition.PROPAGATION_REQUIRES_NEW)).execute(new TransactionCallback<IDataSet>() {
            @Override
            public IDataSet doInTransaction(TransactionStatus status) {
                try {
                    // データベースのバックアップを取得する。
                    IDatabaseConnection connection = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
                    IDataSet backupDataSet = new CachedDataSet(connection.createDataSet(setupDataSet.getTableNames()));

                    // データセットのセットアップを行う。
                    DatabaseOperation.CLEAN_INSERT.execute(connection, setupDataSet);

                    // バックアップデータを返す。
                    return backupDataSet;

                } catch (DatabaseUnitException | SQLException e) {
                    throw new SystemException(e);
                }
            }
        });
    }
}
