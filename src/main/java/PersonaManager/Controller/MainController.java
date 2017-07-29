package PersonaManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap, HttpSession httpSession){
        return "Main/index";
    }
}
