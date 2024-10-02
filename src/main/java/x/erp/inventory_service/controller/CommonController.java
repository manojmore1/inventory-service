package x.erp.inventory_service.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/erp")
public class CommonController {

    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @GetMapping("/dashboard")
    public String  dashboard(HttpServletRequest request, HttpServletResponse response) {
        log.info("Authorization: {}", request.getHeader("Authorization"));
        response.setHeader("Authorization", request.getHeader("Authorization"));
        return "/page/dashboard.html";
    }
}
