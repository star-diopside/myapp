package jp.myapp.function;

import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Timestamp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stax.StAXResult;

import jp.myapp.data.entity.UserAttributeImpl;
import jp.myapp.data.mapper.UserAttributeMapper;
import jp.myapp.data.support.JdbcObjectFactory;
import jp.myapp.exception.SystemException;
import jp.myapp.util.XMLWriterUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private JdbcObjectFactory JdbcObjectFactory;

    @Autowired
    private UserAttributeMapper userAttributeMapper;

    @Override
    @Transactional
    public void process(String userId) {

        try {
            SQLXML xml = this.JdbcObjectFactory.createSQLXML();
            StAXResult result = xml.setResult(StAXResult.class);
            XMLStreamWriter writer = result.getXMLStreamWriter();

            new XMLWriterUtil("    ").write(writer);

            UserAttributeImpl entity = new UserAttributeImpl();
            Timestamp current = new Timestamp(System.currentTimeMillis());

            entity.setUserId(userId);
            entity.setAttribute(xml);
            entity.setRegisterDatetime(current);
            entity.setRegisterUserId(userId);
            entity.setUpdatedDatetime(current);
            entity.setUpdatedUserId(userId);
            entity.setVersion(0);

            this.userAttributeMapper.insert(entity);

        } catch (SQLException | XMLStreamException e) {
            throw new SystemException(e);
        }
    }
}
