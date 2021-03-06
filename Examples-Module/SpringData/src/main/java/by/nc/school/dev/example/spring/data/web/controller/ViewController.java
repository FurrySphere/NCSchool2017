package by.nc.school.dev.example.spring.data.web.controller;

import by.nc.school.dev.example.spring.data.web.Pages;
import by.nc.school.dev.example.spring.data.web.provider.ModelProvider;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(Pages.VIEWS.PATH_ABSOLUTE)
public class ViewController {

    protected Map<String, ModelProvider> modelProviders;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.HOME.PATH)
    public String getHomePage(Model model) {
        processRequest(model, Pages.VIEWS.HOME.VIEW);
        return Pages.VIEWS.HOME.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.LOGIN.PATH)
    public String getLoginPage(Model model) {
        processRequest(model, Pages.VIEWS.LOGIN.VIEW);
        return Pages.VIEWS.LOGIN.VIEW;
    }

    protected void processRequest(Model model, String view) {
        ModelProvider modelProvider = modelProviders.get(view);
        if (modelProvider != null) {
            modelProvider.fillModel(model);
        }
    }

    @Required
    public void setModelProviders(Map<String, ModelProvider> modelProviders) {
        this.modelProviders = modelProviders;
    }

}
