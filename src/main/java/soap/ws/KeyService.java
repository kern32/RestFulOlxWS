package soap.ws;

import dao.KeyDao;
import util.Utility;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Path("/key")

public class KeyService {
   KeyDao keyDao = new KeyDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";

   @POST
   @Path("/add")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createUser(
           @FormParam("key") String name,
           @FormParam("from") String from,
           @FormParam("to") String to,
           @Context HttpServletResponse servletResponse) throws IOException, ParseException {
      Key item = new Key(name, Utility.parseDate(from), Utility.parseDate(to));
      int result = keyDao.addKey(item);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @PUT
   @Path("/update")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateUser(
           @FormParam("key") String name,
           @FormParam("from") String from,
           @FormParam("to") String to,
           @Context HttpServletResponse servletResponse) throws IOException, ParseException {
      Key item = new Key(name, Utility.parseDate(from), Utility.parseDate(to));
      int result = keyDao.updateKey(item);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @GET
   @Path("/get/{keyValue}")
   @Produces(MediaType.APPLICATION_XML)
   public Key getKey(@PathParam("keyValue") String keyValue) throws UnknownHostException {
      return keyDao.getKey(keyValue);
   }

   @DELETE
   @Path("/delete/{keyValue}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteUser(@PathParam("keyValue") String keyValue) throws UnknownHostException {
      int result = keyDao.deleteKey(keyValue);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @GET 
   @Path("/list")
   @Produces(MediaType.APPLICATION_XML) 
   public List<Key> getKeys() throws UnknownHostException {
      return keyDao.getAllKeys();
   }  
   
   @OPTIONS
   @Path("/options")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}
