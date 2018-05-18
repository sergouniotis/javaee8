package com.tns.webapp.servlets;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.Response.Status;

import com.tns.webapp.web.auth.JwtManager;

@WebServlet(urlPatterns = "/login")
public class AuthServlet extends HttpServlet {

	@Inject
	private JwtManager jwtManager;

	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {

		try {

			JsonReader jsonReader = Json.createReader(req.getInputStream());
			JsonObject json = jsonReader.readObject();

			String username = json.getString("username");
			String password = json.getString("password");

			String token = jwtManager.createToken(username, password);

			resp.setHeader("Authorization", "Bearer " + token);
		} catch (Exception e) {
			resp.setStatus(Status.UNAUTHORIZED.getStatusCode());
		}

	};

}
