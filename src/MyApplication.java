package eduardo.prueba.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(rest.class);
        return classes;
    }
}
