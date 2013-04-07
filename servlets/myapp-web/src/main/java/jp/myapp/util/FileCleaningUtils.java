package jp.myapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.struts2.ServletActionContext;

public class FileCleaningUtils {

    public static InputStream trackInputStream(Path path) throws IOException {

        InputStream stream = Files.newInputStream(path);

        ServletContext context = ServletActionContext.getServletContext();
        FileCleaningTracker tracker = FileCleanerCleanup.getFileCleaningTracker(context);
        if (tracker != null) {
            tracker.track(path.toFile(), stream);
        }

        return stream;
    }
}
