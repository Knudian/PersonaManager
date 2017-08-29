package PersonaManager.Api;

import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Persona;
import PersonaManager.Model.Universe;
import PersonaManager.Service.Interface.IGameSystemService;
import PersonaManager.Service.Interface.IPersonaService;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

public class PersonaRestController {


    @Autowired
    protected IPersonaService personaService;

    @Autowired
    protected IUniverseService universeService;

    @Autowired
    protected IGameSystemService gameSystemService;

    @GetMapping("/test")
    public String test(ModelMap modelMap, HttpSession httpSession){
        String str = "[";
        List<Persona> personaList = personaService.getLastPublicPersonnas(6);

        for(Persona p : personaList){
            str += p.toString();
        }
        str += "]";
        System.out.println(personaList);
        return str;
    }

    /**
     * Returns a set of default values :
     * -> Short list of Universes,
     * -> Short list of GameSystems,
     * -> Statistics :
     *  - Most used Universes,
     * -> Last public Personnas
     * @param modelMap ModelMap
     * @param httpSession HttpSession
     * @return String
     */
    @GetMapping("/datas/homepage")
    public String getHomePageDatas(ModelMap modelMap, HttpSession httpSession){

        List<Universe> universeList = universeService.getAll();
        List<GameSystem> gameSystemList = gameSystemService.getAll();

        // Building the string

        String str = "{";
        // Adding the GameSystems List
        str += "'gameSystems':[";
        for(GameSystem gs : gameSystemList){
            str += gs.toString();
        }
        str += "],";
        // Adding the Universe List
        str += "'universes':[";
        for(Universe u : universeList){
            str += u.toString();
        }
        str += "]";
        str += "}";

        return str;
    }
}
