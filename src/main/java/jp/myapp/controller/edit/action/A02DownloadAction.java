package jp.myapp.controller.edit.action;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import jp.myapp.controller.edit.model.A02DownloadModel;
import jp.myapp.controller.edit.model.A02DownloadModelImpl;
import jp.myapp.util.FileCleaningUtils;
import jp.myapp.util.XMLWriterUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class A02DownloadAction extends ActionSupport implements ModelDriven<A02DownloadModel> {

    private static final long serialVersionUID = 1L;

    private A02DownloadModel model = new A02DownloadModelImpl();

    @Override
    public A02DownloadModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {

        Path tempFile = Files.createTempFile(null, null);

        try (OutputStream out = Files.newOutputStream(tempFile)) {
            new XMLWriterUtil("    ").write(out, "UTF-8");
        }

        this.model.setInputStream(FileCleaningUtils.trackInputStream(tempFile));
        this.model.setContentDisposition("attachment; filename=\"sample.xml\"");

        return SUCCESS;
    }
}
