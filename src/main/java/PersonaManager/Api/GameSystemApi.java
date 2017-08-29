package PersonaManager.Api;

import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameSystemApi {

    @Autowired
    protected IGameSystemService gameSystemService;

    @RequestMapping(value="/api/gamesystem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getOneById(@PathVariable(value="id") long id){
        System.out.println("GS : " + id);
        GameSystem gs = gameSystemService.getById(id, false);
        return gs.toString();
    }

    @RequestMapping(value="/api/gamesystem/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        List<GameSystem> gameSystemList = gameSystemService.getAll();
        List<String> str = new ArrayList<String>();
        for(GameSystem gs : gameSystemList){
            str.add(gs.toString());
        }
        return str.toString();
    }

    @RequestMapping(value="/api/gamesystem/new", method = RequestMethod.POST)
    @ResponseBody
    public String postNew(@RequestBody String gsStr){
        System.out.print(gsStr);
        return "test";
    }
}
