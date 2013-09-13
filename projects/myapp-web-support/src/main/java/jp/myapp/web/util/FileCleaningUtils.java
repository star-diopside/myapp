package jp.myapp.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.io.FileCleaningTracker;

public final class FileCleaningUtils {

    private FileCleaningUtils() {
    }

    public static InputStream trackInputStream(Path path) throws IOException {

        // FileCleaningTrackerオブジェクトを取得する。
        ServletContext context = ServletContextHolder.get().getContext();
        FileCleaningTracker tracker = FileCleanerCleanup.getFileCleaningTracker(context);

        // InputStreamを生成し、FileCleaningTrackerオブジェクトに登録する。
        InputStream stream = Files.newInputStream(path);
        tracker.track(path.toFile(), stream);

        return stream;
    }
}
