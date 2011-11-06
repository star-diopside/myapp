package jp.myapp.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.PropertyUtils;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;

public class UserInfo extends UsersImpl {

    private static final long serialVersionUID = -8977622572020663854L;

    /**
     * �R���X�g���N�^
     */
    public UserInfo() {
    }

    /**
     * �R�s�[�R���X�g���N�^
     * 
     * @param source �R�s�[���郆�[�U���
     */
    public UserInfo(Users source) {
        try {
            PropertyUtils.copyProperties(this, source);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * �L���ȃ��[�U��񂩂ǂ����`�F�b�N����B
     * 
     * @return �L�����[�U�̏ꍇ�� true�A�������[�U�̏ꍇ�� false ��Ԃ��B
     */
    public boolean isValidity() {

        if (Boolean.FALSE.equals(this.getProvisionalRegistration())) {
            // �{�o�^�ς݂̏ꍇ�A�L�����[�U�Ƃ���B
            return true;

        } else {
            // ���o�^���̏ꍇ�A�o�^��P���o�߂���Ɩ������[�U�Ƃ���B
            long duration = System.currentTimeMillis() - this.getRegisterDatetime().getTime();

            if (duration <= TimeUnit.DAYS.toMillis(1)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
