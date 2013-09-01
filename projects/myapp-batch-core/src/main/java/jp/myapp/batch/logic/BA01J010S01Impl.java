package jp.myapp.batch.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

/**
 * 郵便番号データダウンロード処理ステップの実装クラス
 */
public class BA01J010S01Impl implements BA01J010S01, InitializingBean {

    /** 郵便番号データダウンロードURL */
    private String uri;

    /** 保存先ファイル */
    private Resource saveFile;

    /**
     * 郵便番号データダウンロードURLを設定する。
     * 
     * @param uri 郵便番号データダウンロードURL
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 保存先ファイル
     * 
     * @param saveFile 保存先ファイル
     */
    public void setSaveFile(Resource saveFile) {
        this.saveFile = saveFile;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // 郵便番号データダウンロードURLが設定されていない場合、プロパティファイルから取得する。
        if (StringUtils.isEmpty(uri)) {
            ResourceBundle resource = ResourceBundle.getBundle("myapp");
            uri = resource.getString("DOWNLOAD_URL.ZIPCODE");
        }
    }

    @Override
    public void execute() throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(new HttpGet(uri));
        HttpEntity entity = response.getEntity();

        File file = saveFile.getFile();
        FileUtils.forceMkdir(file.getParentFile());

        try (InputStream content = entity.getContent();
                OutputStream out = new FileOutputStream(file)) {
            IOUtils.copyLarge(content, out);
        }
    }
}
