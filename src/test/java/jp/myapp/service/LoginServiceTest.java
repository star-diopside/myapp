package jp.myapp.service;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jp.myapp.bean.UserInfo;
import jp.myapp.exception.ApplicationException;
import jp.myapp.exception.NoRollbackApplicationException;
import jp.myapp.test.TestTrace;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
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
    private DataSource dataSource;

    @Autowired
    private LoginService loginService;

    @Rule
    public TestRule testTrace = new TestTrace();

    private IDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {

        Class<?> clazz = this.getClass();
        InputStream is = clazz.getResourceAsStream(clazz.getSimpleName() + "-data.xml");

        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        FlatXmlDataSet fxds = builder.build(is);
        ReplacementDataSet rds = new ReplacementDataSet(fxds);

        rds.addReplacementObject("[NOW_DATETIME]", new Date());

        this.databaseTester = new DataSourceDatabaseTester(this.dataSource);
        this.databaseTester.setDataSet(rds);
        this.databaseTester.onSetup();
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
        UserInfo userInfo = this.loginService.loginUser("ValidUser01", "ValidUser01_Password");
        assertThat(userInfo.isValidity(), is(true));
    }

    /**
     * 仮登録ユーザ（有効時間切れ）のログインテストを行う。
     */
    @Test(expected = NoRollbackApplicationException.class)
    public void testLoginInvalidInterim() throws ApplicationException {
        this.loginService.loginUser("InvalidUser01", "InvalidUser01_Password");
    }

    /**
     * 新規ユーザ登録のテストを行う。
     */
    @Test
    public void testRegisterUser() throws ApplicationException {
        this.loginService.registerUser("userId", "userName", "password");
    }
}
