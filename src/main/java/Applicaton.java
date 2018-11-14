import Model.Help;
import Controller.Controller;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Applicaton {
    public static void main(String[] args) {
        final Logger log=Logger.getLogger(Applicaton.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Application started");
//        Help h=new Help();
//        h.portWorking();
//        Controller.view();
        Controller c=new Controller();
        c.view();

    }
}
