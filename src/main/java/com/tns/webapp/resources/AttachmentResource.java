package com.tns.webapp.resources;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("attachments")
public class AttachmentResource {

	@Path("attach")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response formPost(@Context HttpServletRequest request) {

		MultipartRequestMap map = new MultipartRequestMap(request);

		// Example example = new Example();
		String fileName = map.getStringParameter("name");
		File attachment = map.getFileParameter("attachment");
		
		System.out.println(attachment);
		
		// example.setName(fileName);
		// example.setAttachment(readFile(attachment));

		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response formPost(Map<String, Object> map) {

		map.entrySet().stream().forEach(e->{
			System.out.println(e.getKey() + " " + e.getValue());
		});
		

		return Response.ok().build();
	}	

}
