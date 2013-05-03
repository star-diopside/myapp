package jp.myapp.test.tool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlatDtdDataSetExport implements Runnable {

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Runnable obj = context.getBean("flatDtdDataSetExport", Runnable.class);
            obj.run();
        }
    }

    @Override
    @Transactional
    public void run() {

        try {
            DatabaseConnection conn = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
            IDataSet dataSet = conn.createDataSet();
            try (FileOutputStream out = new FileOutputStream("export.dtd")) {
                FlatDtdDataSet.write(dataSet, out);
            }

        } catch (DatabaseUnitException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
