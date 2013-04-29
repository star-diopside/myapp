package jp.myapp.data.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jp.myapp.data.entity.Users;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@TransactionConfiguration
@Transactional
public class UsersDaoTest {

    @Resource
    private DataSource dataSource;

    @Autowired
    private UsersDao usersDao;

    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception {

        Class<?> clazz = this.getClass();

        try (InputStream is = clazz.getResourceAsStream(clazz.getSimpleName() + "-data.xml")) {

            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            FlatXmlDataSet fxds = builder.build(is);

            this.databaseTester = new DataSourceDatabaseTester(this.dataSource);
            this.databaseTester.setDataSet(fxds);
            this.databaseTester.onSetup();
        }
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void testGet() throws CannotGetJdbcConnectionException, DataSetException, FileNotFoundException,
            IOException, SQLException, DatabaseUnitException {

        Users users = this.usersDao.get("user01");
        assertNotNull(users);
    }
}
