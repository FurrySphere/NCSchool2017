package by.nc.school.dev.example.spring.beans.service;

import by.nc.school.dev.example.spring.beans.util.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class AppConfigServiceImpl implements AppConfigService {

    protected Properties properties;

    private AppConfigServiceImpl() throws IOException {
        properties = new Properties();
        InputStream input = AppConfigServiceImpl.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE);
        try {
            properties.load(input);
        } finally{
            input.close();
        }
    }

    @Override
    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
