package by.nc.school.dev.example.spring.beans.web.provider;

import javax.servlet.http.HttpServletRequest;

public interface ModelProvider {

    void  fillRequest(HttpServletRequest request);

}
