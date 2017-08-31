package PersonaManager.Controller;

import PersonaManager.Model.Persona;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(ModelMap modelMap, HttpSession httpSession){
        return "Main/index";
    }

}
