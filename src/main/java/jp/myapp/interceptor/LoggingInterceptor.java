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

    /** ロガー */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    /** 開始ログフォーマット */
    private String enterMessage = "{0},{1},[START]";

    /** 終了ログフォーマット */
    private String exitMessage = "{0},{1},[END] {2} [ms]";

    /** 例外ログフォーマット */
    private String exceptionMessage = "{0},{1},{2}";

    /** メソッド引数ログフォーマット */
    private String argumentsMessage = "{0},{1},INPUT[{2}]: {3}";

    /** 戻り値ログフォーマット */
    private String resultMessage = "{0},{1},OUTPUT: {2}";

    /**
     * 開始ログのメッセージフォーマットを設定する。<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>クラス名</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>メソッド名</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param enterMessage 開始ログのメッセージフォーマット
     */
    public void setEnterMessage(String enterMessage) {
        this.enterMessage = enterMessage;
    }

    /**
     * 終了ログのメッセージフォーマットを設定する。<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>クラス名</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>メソッド名</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>実行時間（ミリ秒）</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param exitMessage 終了ログのメッセージフォーマット
     */
    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    /**
     * 例外ログのメッセージフォーマットを設定する。<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>クラス名</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>メソッド名</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>例外メッセージ</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param exceptionMessage 例外ログのメッセージフォーマット
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * メソッド引数ログのメッセージフォーマットを設定する。<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>クラス名</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>メソッド名</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>引数のインデックス</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {3}</th>
     * <td>引数の内容</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param argumentsMessage メソッド引数ログのメッセージフォーマット
     */
    public void setArgumentsMessage(String argumentsMessage) {
        this.argumentsMessage = argumentsMessage;
    }

    /**
     * 戻り値ログのメッセージフォーマットを設定する。<br>
     * <p>
     * <table border="0">
     * <tr>
     * <th>PlaceHolder : {0}</th>
     * <td>クラス名</td>
     * <tr>
     * <tr>
     * <th>PlaceHolder : {1}</th>
     * <td>メソッド名</td>
     * </tr>
     * <tr>
     * <th>PlaceHolder : {2}</th>
     * <td>戻り値の内容</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param resultMessage 戻り値ログのメッセージフォーマット
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
            // 実行時間の計測を開始する
            stopWatch.start();

            // 開始ログを出力する
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.enterMessage, className, methodName));
            }

            // 入力パラメータログを出力する
            if (LOGGER.isDebugEnabled()) {
                Object[] arguments = invocation.getArguments();
                for (int i = 0; i < arguments.length; i++) {
                    for (String data : printableObjectList(arguments[i])) {
                        LOGGER.debug(MessageFormat.format(this.argumentsMessage, className, methodName, Integer.valueOf(i), data));
                    }
                }
            }

            // 処理を実行する
            Object result = invocation.proceed();

            // 出力パラメータログを出力する
            if (LOGGER.isDebugEnabled()) {
                // 戻り値が void 以外の場合にログ出力する
                if (!invocation.getMethod().getReturnType().equals(Void.TYPE)) {
                    for (String data : printableObjectList(result)) {
                        LOGGER.debug(MessageFormat.format(this.resultMessage, className, methodName, data));
                    }
                }
            }

            return result;

        } catch (ApplicationException e) {
            // 情報ログを出力する
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.exceptionMessage, className, methodName, "thrown " + e.getClass().getName()));
            }

            // 例外を再スローする
            throw e;

        } catch (Exception e) {
            // エラーログを出力する
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error(MessageFormat.format(this.exceptionMessage, className, methodName, e.getMessage()), e);
            }

            // 例外を再スローする
            throw e;

        } finally {
            // 終了ログを出力する
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(MessageFormat.format(this.exitMessage, className, methodName, Long.valueOf(stopWatch.getTime())));
            }
        }
    }

    /**
     * オブジェクトのインスタンスからログ出力用文字列を生成する。
     * 
     * @param obj ログ出力内容の文字列コレクション
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
