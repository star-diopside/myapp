package jp.myapp.web.controller.common.action;

import jp.myapp.web.controller.common.model.LocaleModel;
import jp.myapp.web.controller.common.model.LocaleModelImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(RequestAttributes.REFERENCE_REQUEST)
public class LocaleAction extends ActionSupport implements ModelDriven<LocaleModel> {

    private static final long serialVersionUID = 1L;

    private LocaleModel model = new LocaleModelImpl();

    @Override
    public LocaleModel getModel() {
        return this.model;
    }
}
