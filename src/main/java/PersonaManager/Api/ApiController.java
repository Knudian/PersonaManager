package PersonaManager.Api;

import PersonaManager.Model.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private ApiResponse apiResponse;

    public ApiController(){ }

    private void reset(){
        this.apiResponse = new ApiResponse();
    }

    @RequestMapping(value="/api/{entity}/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getOneById(@PathVariable(value="id") long id, @PathVariable(value="entity") String entity){
        this.reset();
        switch (entity){
            default:
                this.apiResponse.addError("{'code':'ILLEGAL_ENTITY', 'entity':'"+ entity +"'}");
        }
        return this.apiResponse.toString();
    }

    @RequestMapping(value="/api/{entity}/all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAll(@PathVariable(value="entity") String entity){
        return "getAll(entity :" + entity +")";
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
