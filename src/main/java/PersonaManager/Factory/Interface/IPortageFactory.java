package PersonaManager.Factory.Interface;

import PersonaManager.Model.Portage;

import javax.json.JsonArray;
import java.util.List;

public interface IPortageFactory {

    public String toJson(Portage portage, boolean complete);

    public Portage fromJson(String inputDatas);

    public JsonArray listToJson(List<Portage> list, boolean complete);

    public String allToJson(List<Portage> list, boolean complete);

}
