package PersonaManager.Api;

import PersonaManager.Model.ApiResponse;
import PersonaManager.Service.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    protected ICaracteristicService caracteristicService;
    @Autowired
    protected ICaracteristicModifiedService caracteristicModifiedService;
    @Autowired
    protected IGameSystemService gameSystemService;
    @Autowired
    protected IHumanService humanService;
    @Autowired
    protected IMediaFileService mediaFileService;
    @Autowired
    protected IPersonaService personaService;
    @Autowired
    protected IPersonaCaracteristicService personaCaracteristicService;
    @Autowired
    protected IPersonaTypeService personaTypeService;
    @Autowired
    protected IPortageService portageService;
    @Autowired
    protected IUniverseService universeService;

    private ApiResponse apiResponse;

    public ApiController(){ }

    private void reset(){
        this.apiResponse = new ApiResponse();
    }

    @RequestMapping(value="/api/{entity}/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getOneById(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        try {
            switch (entity) {
                case "caracteristic":
                    apiResponse.addContent(caracteristicService.getById(id).toString());
                    break;
                case "caracteristicmodified":
                    apiResponse.addContent(caracteristicModifiedService.getById(id).toString());
                    break;
                case "gamesystem":
                    apiResponse.addContent(gameSystemService.getById(id, false).toString());
                    break;
                case "human":
                    apiResponse.addContent(humanService.getById(id, false).toString());
                    break;
                case "media":
                    apiResponse.addContent(mediaFileService.getById(id).toString());
                    break;
                case "persona":
                    apiResponse.addContent(personaService.getById(id, false).toString());
                    break;
                case "personacaracteristic":
                    apiResponse.addContent(personaCaracteristicService.getById(id).toString());
                    break;
                case "personatype":
                    apiResponse.addContent(personaTypeService.getById(id).toString());
                    break;
                case "portage":
                    apiResponse.addContent(portageService.getById(id).toString());
                    break;
                case "universe":
                    apiResponse.addContent(universeService.getById(id, false).toString());
                    break;
                default:
                    apiResponse.addError("{'code':'ILLEGAL_ENTITY','message':'" + entity + " does not exists'}");
                    break;
            }
        } catch (NullPointerException e){
            apiResponse.addError("{'code':'ILLEGAL_REQUEST','message':'" + entity + " with id '"+ id +"' does not exists'}");
        }
        return apiResponse.toString();
    }

    @RequestMapping(value="/api/{entity}/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAll(@PathVariable(value="entity") String entity){
        this.reset();
        try {
            switch (entity) {
                case "gamesystem":
                    apiResponse.addContent(gameSystemService.getAll().toString());
                    break;
                case "human":
                    apiResponse.addContent(humanService.getAll().toString());
                    break;
                case "persona":
                    apiResponse.addContent(personaService.getAll().toString());
                    break;
                case "portage":
                    apiResponse.addContent(portageService.getAll().toString());
                    break;
                case "universe":
                    apiResponse.addContent(universeService.getAll().toString());
                    break;
                default:
                    apiResponse.addError("{'code':'ILLEGAL_REQUEST','message':'not authorized'}");
                    break;
            }
        } catch (NullPointerException e){
            apiResponse.addError("{'code':'ILLEGAL_REQUEST','message':'" + entity + " does not exists'}");
        }
        return apiResponse.toString();
    }

    @RequestMapping(value="/api/{entity}/new", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String postNew(@RequestBody String inputString, @PathVariable(value="entity") String entity){
        return "postNew(entity :" + entity + ", with values : "+ inputString +")";
    }

    @RequestMapping(value="/api/{entity}/{id}/update", method = RequestMethod.PATCH, produces = "application/json;charset=UTF-8")
    public String update(@RequestBody String inputString, @PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        return "update(entity:" + entity + ", id:" + id + ", with values: "+ inputString +")";
    }

    @RequestMapping(value="/api/{entity}/{id}/delete", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public String delete(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        return "Requesting deletion of " + entity + " with id " + id;
    }
}
