package PersonaManager.Api.Interface;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IApiInterface {

    @ResponseBody
    public String getOneById(@PathVariable(value="id") long id);

    @ResponseBody
    public String getAll();


}
