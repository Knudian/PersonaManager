package PersonaManager.Service;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Factory.Interface.IUniverseFactory;
import PersonaManager.Model.Portage;
import PersonaManager.Model.Universe;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UniverseService implements IUniverseService {

    public UniverseService() {}

    @Autowired
    private IUniverseDAO universeDAO;

    @Autowired
    private IUniverseFactory universeFactory;

    @Override
    public Long create(String entityAsString) {
        Universe universe = universeFactory.fromJson(entityAsString);
        universe = universeDAO.create(universe);
        return universe.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        return universeFactory.toJson(this.getEntity(id, complete), complete);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        Universe original = this.getEntity(id, false);
        Universe updated  = universeFactory.fromJson(entityAsString);

        if ( !updated.equals(original) ){
            if( updated.getName() != null)
                original.setName(updated.getName());

            if( updated.getDescription() != null)
                original.setDescription(updated.getDescription());


            original.setIllustration(updated.getIllustration());

            original = universeDAO.update(original);
        }
        return universeFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try {
            universeDAO.delete(this.getEntity(id, false));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonValue getAll(boolean complete) {
        return universeFactory.listToJson(universeDAO.getAll(complete), complete);
    }

    @Override
    public Universe getEntity(long id, boolean complete) {
        return universeDAO.getById(id, complete);
    }

    @Override
    public JsonValue patch(long id, String patchingValues) {

        Universe universe = universeFactory.patch(getEntity(id, false), patchingValues);

        return universeFactory.toJson(universeDAO.update(universe), false);
    }

    @Override
    public JsonValue statististics() {
        List<Universe> list = universeDAO.getAll(true);
        return universeFactory.personaInUniverse( list );

    }
}
