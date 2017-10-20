package eduardo.prueba.restful;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class rest{
    @POST
    @Path("/word")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //Recibe un String de no más de 4 caracter en minúscula y devuelve el mismo String en mayúsculas.
    public Response doCaps(word message){
	    if(!message.data.chars().allMatch(Character::isLetter) || message.data.length() > 4){
	    	throw new WebApplicationException(400);
	    }
	    String r = "{\"code\": 200, \"descripcion\": \"OK\", \"data\": \"" + message.data.toUpperCase() + "\"}";
	    return Response.ok(r).build();
    }
    
    @GET
    @Path("/time")
    @Produces(MediaType.APPLICATION_JSON)
    //Recibe hora en formato HH:mm:ss y devuelve la fecha actual y la hora recibida en formato UTC ISODATE.
    public Response getTime(@QueryParam("value") String hora){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    	if(!hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")){
    		throw new WebApplicationException(400);
    	}
    	String[] time = hora.split(":");
    	Calendar today = Calendar.getInstance();
    	today.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
    	today.set(Calendar.MINUTE, Integer.parseInt(time[1]));
    	today.set(Calendar.SECOND, Integer.parseInt(time[2]));
   	    String r = "{\"code\": 200, \"descripcion\": \"OK\", \"data\": \"" + df.format(today.getTime()) + "\"}";
   	    return Response.ok(r).build();    	
    }   
}
