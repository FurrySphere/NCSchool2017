package by.nc.school.dev.controller.abstarctFactory;

public class AbstractActionFactory {
    private final static ActionFactory instance = new ActionFactory();

    public static ActionFactory getInstance() {
        return instance;
    }
}
