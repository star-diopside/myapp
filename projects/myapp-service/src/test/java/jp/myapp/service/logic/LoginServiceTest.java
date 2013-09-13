package jp.myapp.service.logic;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jp.myapp.core.exception.ApplicationException;
import jp.myapp.data.entity.management.Users;
import jp.myapp.service.bean.UserInfoUtil;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class LoginServiceTest {

    @Resource
    private DataSource managementDataSource;

    @Autowired
    private LoginService loginService;

    private IDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {

        Class<?> clazz = this.getClass();

        try (InputStream is = clazz.getResourceAsStream(clazz.getSimpleName() + "-data.xml")) {

            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            FlatXmlDataSet fxds = builder.build(is);
            ReplacementDataSet rds = new ReplacementDataSet(fxds);

            rds.addReplacementObject("[NOW_DATETIME]", new Timestamp(System.currentTimeMillis()));

            this.databaseTester = new DataSourceDatabaseTester(this.managementDataSource);
            this.databaseTester.setDataSet(rds);
            this.databaseTester.onSetup();
        }
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    /**
     * 仮登録ユーザ（有効時間内）のログインテストを行う。
     */
    @Test
    public void testLoginValidInterim() throws ApplicationException {
        Users user = this.loginService.loginUser("ValidUser01", "ValidUser01_Password");
        assertThat(UserInfoUtil.isValid(user), is(true));
    }

    /**
     * 仮登録ユーザ（有効時間切れ）のログインテストを行う。
     */
    @Test(expected = ApplicationException.class)
    public void testLoginInvalidInterim() throws ApplicationException {
        this.loginService.loginUser("InvalidUser01", "InvalidUser01_Password");
    }

    /**
     * 新規ユーザ登録のテストを行う。
     */
    @Test
    public void testRegisterUser() {
        this.loginService.registerUser("userId", "userName", "password");
    }
}
