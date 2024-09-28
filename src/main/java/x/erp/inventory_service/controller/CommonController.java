package x.erp.inventory_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/erp")
public class CommonController {

    @GetMapping("/dashboard")
    public String  dashboard() {
        return "/page/dashboard.html";
    }
}
