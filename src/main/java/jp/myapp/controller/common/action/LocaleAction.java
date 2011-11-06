package jp.myapp.controller.common.action;

import jp.myapp.controller.common.model.LocaleModel;
import jp.myapp.controller.common.model.LocaleModelImpl;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class LocaleAction extends ActionSupport implements ModelDriven<LocaleModel> {

    private static final long serialVersionUID = 1L;

    private LocaleModel model = new LocaleModelImpl();

    @Override
    public LocaleModel getModel() {
        return this.model;
    }
}
