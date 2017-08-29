package PersonaManager.Factory.Interface;

import PersonaManager.Model.Human;

public interface IHumanFactory {

    public String toJson(Human human);

    public Human fromJson(String inputDatas);


}
