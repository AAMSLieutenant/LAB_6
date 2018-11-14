package Controller;

import Model.Help;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Controller {
    private static final Logger log=Logger.getLogger(Controller.class);
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public void view(){
        log.info("Started view");
        Help help=new Help();
        help.portWorking();
    }
}
