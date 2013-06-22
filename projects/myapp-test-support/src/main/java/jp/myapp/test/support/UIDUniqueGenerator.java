package jp.myapp.test.support;

import java.rmi.server.UID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 実行ホスト上で一意となる文字列を生成する。
 */
public class UIDUniqueGenerator implements FactoryBean<String>, InitializingBean {

    /** プレフィックス */
    private String prefix;
    /** サフィックス */
    private String suffix;
    /** ユニークID */
    private String uniqueID;

    /**
     * プレフィックスを設定する。
     * 
     * @param prefix プレフィックス
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * サフィックスを設定する。
     * 
     * @param suffix サフィックス
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        uniqueID = StringUtils.defaultString(prefix) + new UID().toString() + StringUtils.defaultString(suffix);
    }

    @Override
    public String getObject() throws Exception {
        return uniqueID;
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
