package by.nc.school.dev.example.spring.beans.web.provider;

import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

public class ModelProviderFactory {

    protected Map<String, ModelProvider> modelProviders;

    private ModelProviderFactory() {};

    public ModelProvider getInstance(String url) {
        return modelProviders.get(url);
    }

    @Required
    public void setModelProviders(Map<String, ModelProvider> modelProviders) {
        this.modelProviders = modelProviders;
    }

}
