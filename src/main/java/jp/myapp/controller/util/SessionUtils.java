package jp.myapp.controller.util;

import java.util.Map;

/**
 * �t�H�[���f�[�^���Z�b�V���������p�����s�����߂̃��[�e�B���e�B�N���X
 */
public final class SessionUtils {

    private static final String TRANSITION_FORM_KEY = "TRANSITION_FORM_KEY";
    private Map<String, Object> session;

    public SessionUtils(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * �t�H�[���̌^���w�肵�ăZ�b�V��������t�H�[���f�[�^���擾����B
     * 
     * @param formType �t�H�[���̌^
     * @return �Z�b�V��������擾�����t�H�[���f�[�^�B�Z�b�V�����ɑ��݂��Ȃ��ꍇ��null�B
     */
    public <T> T getForm(Class<T> formType) {

        Object form = this.session.get(TRANSITION_FORM_KEY);

        if (formType.isInstance(form)) {
            return formType.cast(form);
        }

        return null;
    }

    /**
     * �Z�b�V�����Ƀt�H�[���f�[�^��ݒ肷��B
     * 
     * @param form �Z�b�V�����ɓo�^����t�H�[���f�[�^
     */
    public void setForm(Object form) {
        this.session.put(TRANSITION_FORM_KEY, form);
    }

    /**
     * �Z�b�V��������t�H�[���f�[�^���폜����B
     */
    public void removeForm() {
        this.session.remove(TRANSITION_FORM_KEY);
    }
}
