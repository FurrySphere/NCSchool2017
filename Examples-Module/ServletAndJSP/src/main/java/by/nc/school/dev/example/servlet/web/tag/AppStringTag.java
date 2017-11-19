package by.nc.school.dev.example.servlet.web.tag;

import by.nc.school.dev.example.servlet.service.AppStringsService;
import by.nc.school.dev.example.servlet.service.ServiceFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class AppStringTag extends SimpleTagSupport {

    private String key;

    private Object[] substitution;

    public void setKey(String key) {
        this.key = key;
    }

    public void setSubst(Object subst) {
        this.substitution = new Object[]{subst};
    }

    public void setSubst(Object[] subst) {
        this.substitution = subst;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        AppStringsService appStringsService = new ServiceFactory().getAppStringsServiceInstance();
        out.print(appStringsService.getString(key, substitution));
    }

}
