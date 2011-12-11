package jp.myapp.controller.edit.action;

import java.io.ByteArrayInputStream;

import jp.myapp.controller.edit.model.A02DownloadModel;
import jp.myapp.controller.edit.model.A02DownloadModelImpl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class A02DownloadAction extends ActionSupport implements ModelDriven<A02DownloadModel> {

    private static final long serialVersionUID = 1L;

    private A02DownloadModel model = new A02DownloadModelImpl();

    @Override
    public A02DownloadModel getModel() {
        return this.model;
    }

    @Override
    public String execute() throws Exception {

        this.model.setInputStream(new ByteArrayInputStream(this.model.toString().getBytes()));
        this.model.setContentDisposition("attachment; filename=\"string.txt\"");

        return SUCCESS;
    }
}
