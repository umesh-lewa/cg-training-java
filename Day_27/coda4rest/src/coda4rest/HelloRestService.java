package coda4rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloRestService {
	
	@GET
	public void sayHello() {
		System.out.println("Welcome to REST............");
	}
	
	@GET
	@Path("/hello2")
	public void sayHello2() {
		System.out.println("Welcome to REST...2222222222222222222.........");
	}
	
	@GET
	@Path("/hello3")
	public Response sayHello3() {
		System.out.println("Welcome to REST...3333333333333333.........");
		return Response.status(200).entity("<h1>Welcome to REST...33333.....").build();
	}
	
	//http://localhost:2020/coda4rest/rest/hello/hello5/codapresedio/sharan
	@GET
	@Path("/hello4/{uname}/{ceo}")
	public Response sayHello4(@PathParam("uname") String n,@PathParam("ceo") String ceo) {
		System.out.println("Welcome to REST...4444444........."+n+": and ceo is"+ceo);
		return Response.status(200).entity("<h1>Welcome to REST...444444....."+n+": and ceo is"+ceo).build();
	}
	
	//http://localhost:2020/coda4rest/rest/hello/hello5/?uname=codapresedio&&ceo=sharan
	@GET
	@Path("/hello5")
	public Response sayHello5(@QueryParam("uname") String n,@QueryParam("ceo") String ceo) {
		System.out.println("Welcome to REST...55555........."+n+": and ceo is"+ceo);
		return Response.status(200).entity("<h1>Welcome to REST...5555....."+n+": and ceo is"+ceo).build();
	}
	
	@GET
	@Path("/hello6")
	public Response sayHello6(@Context UriInfo uriInfo) {
		String n=uriInfo.getQueryParameters().getFirst("uname");
		String ceo=uriInfo.getQueryParameters().getFirst("ceo");
		System.out.println("Welcome to REST...6666........."+n+": and ceo is"+ceo);
		return Response.status(200).entity("<h1>Welcome to REST...666....."+n+": and ceo is"+ceo).build();
	}
	
	@GET
	@Path("/hello7")
	public Response sayHello7(@MatrixParam("sid") String sid) {
		System.out.println("Welcome to REST...777........."+sid);
		return Response.status(200).entity("<h1>Welcome to REST...7....."+sid).build();
	}
	
	@POST
	@Path("/hello8")
	public Response sayHello8(@FormParam("uname") String uname,@FormParam("upass") String upass) {
		System.out.println("Welcome to REST...8888........."+uname+":"+upass);
		return Response.status(200).entity("<h1>Welcome to REST...8888....."+uname+":"+upass).build();
	}
	
}
