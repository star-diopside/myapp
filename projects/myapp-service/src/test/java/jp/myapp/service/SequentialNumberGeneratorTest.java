package jp.myapp.service;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jp.myapp.test.support.DatabaseDumper;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class SequentialNumberGeneratorTest {

    @Resource
    private DataSource applicationDataSource;

    @Autowired
    @Qualifier("applicationDatabaseDumper")
    private DatabaseDumper applicationDatabaseDumper;

    @Autowired
    private SequentialNumberGenerator sequentialNumberGenerator;

    private IDataSet testDataSet;
    private IDataSet beforeDataSet;

    @Before
    public void before() throws Exception {

        Class<?> clazz = this.getClass();

        try (InputStream is = clazz.getResourceAsStream(clazz.getSimpleName() + "-data.xml")) {
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            testDataSet = builder.build(is);
            beforeDataSet = applicationDatabaseDumper.setUp(testDataSet);
        }
    }

    @After
    public void after() throws Exception {
        applicationDatabaseDumper.setUp(beforeDataSet);
    }

    @Test
    public void testGenerate() {
        assertThat(sequentialNumberGenerator.generate("0001"), is("ID00000001N"));
    }
}
