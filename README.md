# PersonaManager

### Routes de l'API:
- GET ```/api/{entity}/{id}```           : Entity
- GET ```/api/{entity}/all```            : [ Entity ]
- POST ```/api/{entity}/new```           : Entity
- POST ```/api/{entity}/{id}/update```   : Entity
- DELETE ```/api/{entity}/{id}/delete``` : Boolean

### Structure des objets (et nom des ```entity```) :
human :
```json
{
    "id"        : Number human_id,
    "nick"      : String human.nick,
    "email"     : String human.email,
    "password"  : String human.password
}
```
gamesystem :
```json
{
    "id"                : Number gameSystem.id,
    "name"              : String gameSystem.name,
    "shortName"         : String gameSystem.shortName,
    "url"               : String gameSystem.webSite,
    "media"             : String gameSystem.illustration,
    "portageList"       : Number[] gameSystem.portageList,
    "caracteristicList" : Number[] gameSystem.caracteristicList
}
```
persona :
```json
{
    "id"              : Number persona.id,
    "owner"           : Number persona.owner,
    "isPublic"        : Boolean persona.isPublic,
    "firstName"       : String persona.firstName,
    "lastName"        : String persona.lastName,
    "lastUpdate"      : TimeStamp persona.lastUpdate,
    "creationTime"    : TimeStamp persona.creationTime,
    "media"           : String persona.image,
    "type"            : Number persona.type,
    "portageId"       : Number persona.portage,
    "gender"          : String persona.gender,
    "caracteristics"  : Object[] persona.caracteristics,
    "description"     : String persona.description
}
```
caracteristic :
```json
{
    "id"          : Number caracteristic.id,
    "gameSystem"  : Number caracteristic.gameSystem,
    "type"        : String caracteristic.type,
    "label"       : String caracteristic.label,
    "min"         : String caracteristic.minimum
    "max"         : String caracteristic.maximum
}
```

personatype :
```json
{
    "id"          : Number personaType.id,
    "name"        : String personaType.name,
    "universeId"  : Number personaType.universeId
}
```

portage :
```json
{
    "id"                : Number portage.id,
    "universeId"        : Number portage.universe,
    "gameSystemId"      : Number portage.gameSystem,
    "creationTime"      : TimeStamp portage.creationTime,
    "personaList"       : Int[] portage.personaList,
    "caracteristicList" : Int[] portage.caracteristicList
}
```

universe :
```json
{
    "id":2,
    "name":"Univers 2",
    "description":"Description univers 2",
    "media":"undefined",
    "creationTime":1504146268000,
    "portageList":"",
    "personaTypeList":""
}
```