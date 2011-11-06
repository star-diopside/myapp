package jp.myapp.interceptor;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;

import jp.myapp.exception.ApplicationException;
import jp.myapp.util.Loggable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingInterceptor implements MethodInterceptor {

    /** ���K�[ */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    /** �J�n���O�t�H�[�}�b�g */
    private String enterMessage = "{0},{1},[START]";

    /** �I�����O�t�H�[�}�b�g */
    private String exitMessage = "{0},{1},[END] {2} [ms]";

    /** ��O���O�t�H�[�}�b�g */
    private String exceptionMessage = "{0},{1},{2}";

    /** ���\�b�h�������O�t�H�[�}�b�g */
    private String argumentsMessage = "{0},{1},INPUT[{2}]: {3}";

    /** �߂�l���O�t�H�[�}�b�g */
    private String resultMessage = "{0},{1},OUTPUT: {2}";

    /**
     * �J�n���O�̃��b�Z�[�W�t�H�[�}�b�g��ݒ肷��B<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>�N���X��</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>���\�b�h��</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param enterMessage �J�n���O�̃��b�Z�[�W�t�H�[�}�b�g
     */
    public void setEnterMessage(String enterMessage) {
        this.enterMessage = enterMessage;
    }

    /**
     * �I�����O�̃��b�Z�[�W�t�H�[�}�b�g��ݒ肷��B<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>�N���X��</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>���\�b�h��</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>���s���ԁi�~���b�j</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param exitMessage �I�����O�̃��b�Z�[�W�t�H�[�}�b�g
     */
    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    /**
     * ��O���O�̃��b�Z�[�W�t�H�[�}�b�g��ݒ肷��B<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>�N���X��</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>���\�b�h��</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>��O���b�Z�[�W</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param exceptionMessage ��O���O�̃��b�Z�[�W�t�H�[�}�b�g
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * ���\�b�h�������O�̃��b�Z�[�W�t�H�[�}�b�g��ݒ肷��B<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>�N���X��</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>���\�b�h��</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>�����̃C���f�b�N�X</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {3}</th>
     * <td>�����̓��e</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param argumentsMessage ���\�b�h�������O�̃��b�Z�[�W�t�H�[�}�b�g
     */
    public void setArgumentsMessage(String argumentsMessage) {
        this.argumentsMessage = argumentsMessage;
    }

    /**
     * �߂�l���O�̃��b�Z�[�W�t�H�[�}�b�g��ݒ肷��B<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>�N���X��</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>���\�b�h��</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>�߂�l�̓��e</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param resultMessage �߂�l���O�̃��b�Z�[�W�t�H�[�}�b�g
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        String className = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();

        try {
            // ���s���Ԃ̌v�����J�n����
            stopWatch.start();

            // �J�n���O���o�͂���
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.enterMessage, className, methodName));
            }

            // ���̓p�����[�^���O���o�͂���
            if (LOGGER.isDebugEnabled()) {
                Object[] arguments = invocation.getArguments();
                for (int i = 0; i < arguments.length; i++) {
                    for (String data : printableObjectList(arguments[i])) {
                        LOGGER.debug(MessageFormat.format(this.argumentsMessage, className, methodName, Integer.valueOf(i), data));
                    }
                }
            }

            // ���������s����
            Object result = invocation.proceed();

            // �o�̓p�����[�^���O���o�͂���
            if (LOGGER.isDebugEnabled()) {
                // �߂�l�� void �ȊO�̏ꍇ�Ƀ��O�o�͂���
                if (!invocation.getMethod().getReturnType().equals(Void.TYPE)) {
                    for (String data : printableObjectList(result)) {
                        LOGGER.debug(MessageFormat.format(this.resultMessage, className, methodName, data));
                    }
                }
            }

            return result;

        } catch (ApplicationException e) {
            // ��񃍃O���o�͂���
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.exceptionMessage, className, methodName, "thrown " + e.getClass().getName()));
            }

            // ��O���ăX���[����
            throw e;

        } catch (Exception e) {
            // �G���[���O���o�͂���
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error(MessageFormat.format(this.exceptionMessage, className, methodName, e.getMessage()), e);
            }

            // ��O���ăX���[����
            throw e;

        } finally {
            // �I�����O���o�͂���
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.exitMessage, className, methodName, Long.valueOf(stopWatch.getTime())));
            }
        }
    }

    /**
     * �I�u�W�F�N�g�̃C���X�^���X���烍�O�o�͗p������𐶐�����B
     * 
     * @param obj ���O�o�͓��e�̕�����R���N�V����
     */
    private static Collection<String> printableObjectList(Object obj) {

        if (obj == null) {
            return Arrays.asList((String) null);
        } else if (obj instanceof Loggable) {
            Collection<String> logText = ((Loggable) obj).getLogText();
            if (logText == null) {
                return Arrays.asList((String) null);
            } else {
                return logText;
            }
        } else {
            return Arrays.asList(obj.toString());
        }
    }
}
