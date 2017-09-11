package PersonaManager.Api;

import PersonaManager.Model.ApiResponse;
import PersonaManager.Service.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApiController {

    private ApiResponse apiResponse;

    public ApiController(){ }

    // list of authorized entities
    private final String CARACTERISTIC          = "caracteristic";
    private final String CARACTERISTIC_MODIFIED = "caracteristicmodified";
    private final String GAME_SYSTEM            = "gamesystem";
    private final String HUMAN                  = "human";
    private final String MEDIA                  = "media";
    private final String PERSONA_CARACTERISTIC  = "personacaracteristic";
    private final String PERSONA                = "persona";
    private final String PERSONA_TYPE           = "personatype";
    private final String PORTAGE                = "portage";
    private final String UNIVERSE               = "universe";

    @Autowired
    private IGameSystemService gameSystemService;

    @Autowired
    private IHumanService humanService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPersonaTypeService personaTypeService;

    @Autowired
    private IPortageService portageService;

    @Autowired
    private IUniverseService universeService;

    @Autowired
    private ICaracteristicService caracteristicService;

    @Autowired
    private IMediaFileService mediaFileService;

    @Autowired
    private IPersonaCaracteristicService personaCaracteristicService;

    @Autowired
    private ICaracteristicModifiedService caracteristicModifiedService;

    private void reset(){
        this.apiResponse = new ApiResponse();
    }

    @RequestMapping(
            value={
                    "/api/{entity}/{id}",
                    "/api/{entity}/{id}/{complete}"
            },
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getOneById(
            @PathVariable(value="id") long id,
            @PathVariable(value="entity") String entity,
            @PathVariable(value="complete", required = false, name = "complete") String fullMode
    ){

        boolean complete = false;
        if( fullMode != null){
            complete = true;
        }

        this.reset();
        try {
            String response = "";
            switch (entity) {
                case CARACTERISTIC:
                    response = caracteristicService.getById(id);
                    break;
                case CARACTERISTIC_MODIFIED:
                    response = caracteristicService.getById(id);
                    break;
                case GAME_SYSTEM:
                    response = gameSystemService.getById(id, complete);
                    break;
                case HUMAN:
                    response = humanService.getById(id, complete);
                    break;
                case MEDIA:
                    response = mediaFileService.getById(id);
                    break;
                case PERSONA:
                    response = personaService.getById(id, complete);
                    break;
                case PERSONA_TYPE:
                    response = personaTypeService.getById(id);
                    break;
                case PERSONA_CARACTERISTIC:
                    response = personaCaracteristicService.getById(id);
                    break;
                case PORTAGE:
                    response = portageService.getById(id, complete);
                    break;
                case UNIVERSE:
                    response = universeService.getById(id, complete);
                    break;
            }

            this.apiResponse.addContent(response);

        } catch (NullPointerException e) {
            this.apiResponse.addError("{'code':'ITEM_DOES_NOT_EXISTS', 'entity':'" + entity + "', 'id':" + id + ", complete : "+ complete +"}");
        }

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/all",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getAll(@PathVariable(value="entity") String entity){
        this.reset();
        String result;
        switch (entity){
            case PERSONA:
                result = personaService.getAll();
                break;
            default :
                result =  "getAll(entity :" + entity +")";
        }
        this.apiResponse.addContent(result);

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String postNew(@RequestParam(value = "entity") String inputString, @PathVariable(value="entity") String entity){

        this.reset();

        long returnedId = 0;
        switch (entity){
            case HUMAN:
                returnedId = humanService.create(inputString);
                break;
            case GAME_SYSTEM:
                returnedId = gameSystemService.create(inputString);
                break;
            case PERSONA:
                returnedId = personaService.create(inputString);
                break;
            case PERSONA_TYPE:
                returnedId = personaTypeService.create(inputString);
                break;
            case PORTAGE:
                returnedId = portageService.create(inputString);
                break;
            case UNIVERSE:
                returnedId = universeService.create(inputString);
                break;
            case CARACTERISTIC:
                returnedId = caracteristicService.create(inputString);
                break;
            case PERSONA_CARACTERISTIC:
                returnedId = personaCaracteristicService.create(inputString);
                break;
            case CARACTERISTIC_MODIFIED:
                returnedId = caracteristicModifiedService.create(inputString);
                break;
            default:
                this.apiResponse.addContent("postNew(entity :" + entity + ", with values : "+ inputString +")");
                break;
        }
        this.apiResponse.addContent("{'id':"+ returnedId +"}");

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/{id}",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String update(@RequestParam(value="entity") String inputString, @PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        String response = "";
        switch (entity){
            case HUMAN:
                response = humanService.update(inputString, id);
                break;
            case GAME_SYSTEM :
                response = gameSystemService.update(inputString, id);
                break;
            case UNIVERSE:
                response = universeService.update(inputString, id);
                break;
            case CARACTERISTIC:
                response = caracteristicService.update(inputString, id);
                break;
            case PERSONA_TYPE:
                response = personaTypeService.update(inputString, id);
                break;
            case PORTAGE:
                response = portageService.update(inputString, id);
                break;
            case CARACTERISTIC_MODIFIED:
                response = caracteristicModifiedService.update(inputString, id);
                break;
            case PERSONA:
                response = personaService.update(inputString, id);
                break;
            default :
                this.apiResponse.addContent("update(entity:" + entity + ", id:" + id + ", with values: "+ inputString +")");
                break;
        }
        this.apiResponse.addContent(response);
        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public String delete(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        Boolean status = false;
        switch (entity){
            case HUMAN:
                status = humanService.delete(id);
                break;
            case GAME_SYSTEM :
                status = gameSystemService.delete(id);
                break;
            case UNIVERSE:
                status = universeService.delete(id);
                break;
            case CARACTERISTIC:
                status = caracteristicService.delete(id);
                break;
            case PERSONA_TYPE:
                status = personaTypeService.delete(id);
                break;
            case PORTAGE:
                status = portageService.delete(id);
                break;
            case CARACTERISTIC_MODIFIED:
                status = caracteristicModifiedService.delete(id);
                break;
            case PERSONA:
                status = personaService.delete(id);
            default:
                this.apiResponse.addError("Requesting deletion of " + entity + " with id " + id);
                break;
        }
        this.apiResponse.addContent("{'successful':" + status +"}");
        return this.apiResponse.toString();
    }
}
