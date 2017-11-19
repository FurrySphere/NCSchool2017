package by.nc.school.dev.example.servlet.web.provider;

import by.nc.school.dev.example.servlet.persistence.DAOFactory;
import by.nc.school.dev.example.servlet.web.Pages;

import java.util.HashMap;
import java.util.Map;

public class ModelProviderFactory {

    protected static Map<String, ModelProvider> modelProviders;

    public ModelProvider getInstance(String url) {
        // Redundant factory synchronization can be avoided by the double null check trick:
        if (modelProviders != null) {
            return modelProviders.get(url);
        }
        synchronized (ModelProvider.class) {
            // we still have to check for null, because other threads could instantiate the object
            // between previous check and synchronized block
            if (modelProviders == null) {
                modelProviders = new HashMap<>();
                // home
                HomeModelProvider homeModelProvider = new HomeModelProvider();
                homeModelProvider.setUserDAO(new DAOFactory().getUserDaoInstance());
                modelProviders.put(Pages.HOME_PAGE, homeModelProvider);
            }
        }
        return modelProviders.get(url);
    }

}
