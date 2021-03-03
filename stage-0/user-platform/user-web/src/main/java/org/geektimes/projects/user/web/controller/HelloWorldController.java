package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "index.jsp";
    }


    @GET
    @Path("/regSuccess") // /hello/world -> HelloWorldController
    public String index(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "regSuccess.jsp";
    }



    @GET
    @POST
    @Path("/register") // /hello/world -> HelloWorldController
    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        if(request.getMethod().equals("GET")) {
            return "register.jsp";
        }
        else{
            Map<String, Object> params = new HashMap<>();
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
            User user = new User();
            user.setName((String)params.get("name"));
            user.setPassword((String)params.get("password"));
            user.setEmail((String)params.get("email"));
            user.setPhoneNumber((String)params.get("phone"));
            UserServiceImpl service = new UserServiceImpl();
            boolean regResult = service.register(user);
            if(regResult){
                return "regSuccess.jsp";
            }
            else{
                return "index.jsp";
            }
        }
    }
}
