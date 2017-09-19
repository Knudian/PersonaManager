package PersonaManager.Api;

import PersonaManager.Model.ApiResponse;
import PersonaManager.Service.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

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
    public String getOneById(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity, @PathVariable(value="complete", required = false, name = "complete") String complete){

        boolean disableLazyLoading = ( complete != null && complete.equals("complete"));

        this.reset();

        JsonValue response = JsonValue.EMPTY_JSON_OBJECT;
        try {
            switch (entity) {
                case CARACTERISTIC:
                    response = caracteristicService.getById(id);
                    break;
                case CARACTERISTIC_MODIFIED:
                    response = caracteristicService.getById(id);
                    break;
                case GAME_SYSTEM:
                    response = gameSystemService.getById(id, disableLazyLoading);
                    break;
                case HUMAN:
                    response = humanService.getById(id, disableLazyLoading);
                    break;
                case MEDIA:
                    response = mediaFileService.getById(id);
                    break;
                case PERSONA:
                    response = personaService.getById(id, disableLazyLoading);
                    break;
                case PERSONA_TYPE:
                    response = personaTypeService.getById(id);
                    break;
                case PERSONA_CARACTERISTIC:
                    response = personaCaracteristicService.getById(id);
                    break;
                case PORTAGE:
                    response = portageService.getById(id, disableLazyLoading);
                    break;
                case UNIVERSE:
                    response = universeService.getById(id, disableLazyLoading);
                    break;
            }

            this.apiResponse.addContent(response);
        } catch (NullPointerException e){
            JsonObject model = Json.createObjectBuilder()
                    .add("code", "ITEM_DOES_NOT_EXISTS")
                    .add("entity", entity)
                    .add("id", id)
                    .build();
            this.apiResponse.addError(model);
        }
        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/all",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getAll(@PathVariable(value="entity") String entity){
        this.reset();
        JsonValue response = JsonValue.NULL;
        try {
            switch (entity) {
                case PERSONA:
                    response = personaService.getAll();
                    break;
                case UNIVERSE:
                    response = universeService.getAll(true);
                    break;
                case GAME_SYSTEM:
                    response = gameSystemService.getAll();
                    break;
                case PORTAGE:
                    response = portageService.getAll(true);
                    break;
            }
            this.apiResponse.addContent(response);
        } catch (NullPointerException e){
            JsonValue model = Json.createObjectBuilder()
                    .add("code", "NO_ITEM_EXISTS")
                    .add("entity", Json.createValue(entity))
                    .build();
            this.apiResponse.addError(model);
        }

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String postNew(@RequestParam(value = "entity") String inputString, @PathVariable(value="entity") String entity){

        this.reset();
        JsonValue response = JsonValue.EMPTY_JSON_OBJECT;
        try {
            switch (entity) {
                case HUMAN:
                    response = humanService.getById(humanService.create(inputString), false);
                    break;
                case GAME_SYSTEM:
                    response = gameSystemService.getById(gameSystemService.create(inputString), false);
                    break;
                case UNIVERSE:
                    response = universeService.getById(universeService.create(inputString), false);
                    break;
                case CARACTERISTIC:
                    response = caracteristicService.getById(caracteristicService.create(inputString));
                    break;
                case PORTAGE:
                    response = portageService.getById(portageService.create(inputString), false);
                    break;
                case PERSONA_TYPE:
                    response = personaTypeService.getById(personaTypeService.create(inputString));
                    break;
                case PERSONA:
                    response = personaService.getById(personaService.create(inputString), false);
                    break;
            }

            this.apiResponse.addContent(response);
        } catch (NullPointerException e) {
            e.printStackTrace();
            JsonObject model = Json.createObjectBuilder()
                    .add("code", "ITEM_CANNOT_BE_CREATED")
                    .add("entity", entity)
                    .add("value", inputString)
                    .build();
            this.apiResponse.addError(model);
        }

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/{id}",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String update(@RequestParam(value="entity") String inputString, @PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        JsonValue response = JsonValue.NULL;
        try {
            switch (entity) {
                case HUMAN:
                    response = humanService.patch(id, inputString);
                    break;
                case GAME_SYSTEM:
                    response = gameSystemService.patch(id, inputString);
                    break;
                case UNIVERSE:
                    response = universeService.patch(id, inputString);
                    break;
                case CARACTERISTIC:
                    response = caracteristicService.patch(id, inputString);
                    break;
                case CARACTERISTIC_MODIFIED:
                    response = caracteristicModifiedService.patch(id, inputString);
                    break;
                case PERSONA:
                    response = personaService.patch(id, inputString);
                    break;
                default:
                    JsonObject model = Json.createObjectBuilder()
                            .add("code", "UPDATE_FORBIDDEN")
                            .add("entity", entity)
                            .build();
                    this.apiResponse.addError(model);
            }
            this.apiResponse.addContent(response);
        } catch (Exception e){
            JsonValue model = Json.createObjectBuilder()
                    .add("code", "ITEM_CANNOT_BE_UPDATED")
                    .add("entity", Json.createValue(entity))
                    .add("id", id)
                    .add("input", Json.createValue(inputString))
                    .build();
            this.apiResponse.addError(model);
        }

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value="/api/{entity}/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public String delete(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        Boolean status = false;
        try {
            switch (entity) {
                case HUMAN:
                    status = humanService.delete(id);
                    break;
                case GAME_SYSTEM:
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
            }

            this.apiResponse.addContent(status ? JsonValue.TRUE : JsonValue.FALSE );
        } catch (Exception e){
            JsonValue model = Json.createObjectBuilder()
                    .add("code", "ITEM_DOES_NOT_EXISTS")
                    .add("entity", Json.createValue(entity))
                    .add("exception", Json.createValue(e.getMessage()))
                    .build();
            this.apiResponse.addError(model);
        }
        return this.apiResponse.toString();
    }

    @RequestMapping(
            value = "/api/universe/statistics",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getUniverseStatistics(){

        this.reset();
        try {
            this.apiResponse.addContent(universeService.statististics());
        } catch (Exception e){
            e.printStackTrace();
        }

        return this.apiResponse.toString();
    }

    @RequestMapping(
            value = "/api/lastpublicpersonas/{quantity}",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getLastPublicPersonas(@PathVariable(value="quantity") Integer quantity){
        this.reset();

        try{
            this.apiResponse.addContent(personaService.getLastPublicPersonnas(quantity));
        } catch (Exception e){
            e.printStackTrace();
        }

        return  this.apiResponse.toString();
    }

    @RequestMapping(
            value ="/api/homepage",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public String getDatasForHomePage() {
        this.reset();
        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("personas", personaService.getLastPublicPersonnas(6)).build());
        } catch (Exception e){
        // doNothing;
        }

        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("universeList", universeService.getAll(true)).build());
        } catch ( Exception e){
            // do nothing;
        }

        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("universeStat", universeService.statististics()).build());
        } catch (Exception e){
            // do nothing
        }

        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("gameSystemList", gameSystemService.getAll()).build());
        } catch (Exception e){
            // do nothing;
        }

        try {
             this.apiResponse.addContent(Json.createObjectBuilder().add("humanList", humanService.getAll()).build());
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("portageList", portageService.getAll(true)).build());
        } catch (Exception e){
            // do nothing
        }

        return this.apiResponse.toString();

    }

    @RequestMapping(
            value = "/api/persona/list/{page}/{quantity}",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    public String getPublicPersonasForPage(@PathVariable(value="page") int page, @PathVariable(value="quantity") int quantity){
        this.reset();
        try {
            this.apiResponse.addContent(Json.createObjectBuilder().add("personaCount", personaService.getCountPublic()).build());
            this.apiResponse.addContent(personaService.getPublicPersonasForPage(page, quantity));
        } catch (Exception e){
            e.printStackTrace();
        }

        return this.apiResponse.toString();

    }
}
