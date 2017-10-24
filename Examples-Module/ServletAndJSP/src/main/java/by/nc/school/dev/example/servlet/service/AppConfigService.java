package by.nc.school.dev.example.servlet.service;

public interface AppConfigService {

    String KEY_INMEMORY_STORAGE_FILE = "storage.file";

    String getPropertyValue(String property);

}
