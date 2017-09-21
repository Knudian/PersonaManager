package PersonaManager.Service.Interface;

import javax.json.JsonValue;

public interface IStandardService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonValue patch(long id, String patchingValues);
}
