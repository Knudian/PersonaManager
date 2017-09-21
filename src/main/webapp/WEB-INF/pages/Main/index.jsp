<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Persona Manager</title>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
        <script src="/resources/js/jquery.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <style>
            body {
                font-family: "Courier New" !important;
                padding : 20px !important;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <aside class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <div class="well well-lg">
                        <h1 class="text-primary text-center">Persona<br/>Manager</h1>
                    </div>
                </aside>
                <main  class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                    <div class="row">
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="about">
                                    <h2 class="page-header"><samp>The project</samp></h2>
                                    <p>This application is a J2EE/Spring application, which aims to store <abbr title="Role Playing Games">RPG</abbr> persona.</p>
                                    <hr/>
                                    <h3>Datas stored</h3>
                                    <p>A less as possible datas are stored. So, the application does not calculate anythings. It just stores.</p>
                                    <ul>
                                        <li><code>gamesystem</code> : a RPG rule set,</li>
                                        <li><code>universe</code> : a RPG background,</li>
                                        <li><code>caracteristic</code> : a basic information withing the gamesystem,</li>
                                        <li><code>personatype</code> : the jobs and/or classes available in an universe,</li>
                                        <li><code>portage</code> : the application of a gamesystem witn an universe,</li>
                                        <li><code>caracteristicmodified</code> : the override of a caracteritic, inside a portage,</li>
                                        <li><code>persona</code> : a persona played using a portage</li>
                                        <li><code>personacaracteristic</code> : the value of the caracteristicmodifieds for a specific persona.</li>
                                    </ul>
                                    <p>In this way, if you want to play in a specific universe, but don't like the official system, you can change to another system, for example, playing in a <em>Dungeons & Dragons</em> universe, with the rules of <em>Cthulu</em>.</p>
                                    <p>Enjoy, and have fun !</p>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="apiOverview">
                                    <h2 class="page-header"><samp>The application's <abbr title="Application Programming Interface">API</abbr></samp></h2>
                                    <p>This application is based on a API, and stores the informations, and gives back answers to the available requests.</p>
                                    <p>To make it easier, we provide you an unified set of data routes, for which you would have 3 elements to provide.</p>
                                    <p>We also make use a lot of the HTTP verbs, to differenciate each route.</p>
                                    <p>In the menu, you will find the different ways to use our application.</p>
                                    <p>If you have any problem with it, you are free to send us issues via Github.</p>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="entities">
                                    <h2 class="page-header"><samp>The entities</samp></h2>
                                    <p>In the following pages, you will have a short description of the major entities accessible with the API.</p>
                                    <p>For each entity, you will have a <code>keyword</code> provided, to use in the routes, to define the type of entity you want the access of.</p>
                                    <p>Below each, you will have a table describing the JSON object used.</p>
                                    <p>The entity are listed alphabetically, for an easier access.</p>
                                </div>
                                <div role="tabpanel" class="tab-pane table-responsive" id="caracteristic">
                                    <h2 class="page-header"><samp>Caracteristic</samp></h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>A <code>caracteristic</code> is the description of a caracteristic, as the name implies, as well as the skills that can be described or evaluated in a GameSystem.</dd>
                                        <dt>Keyword</dt>
                                        <dd><code>caracteristic</code></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                            <tr>
                                                <th>Attribute</th>
                                                <th>Type</th>
                                                <th>Description</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>gamesystem</td><td>Integer/Object</td><td>Integer : a reference to the gamesystem the entity is belonging to.<br/>
                                        Object : See the <code>gamesystem</code> description.</td></tr>
                                        <tr><td>type</td><td>String</td><td>The type of data stored.<br/>Authorized values are :"string","integer","boolean".</td></tr>
                                        <tr><td>defaultLabel</td><td>String</td><td>The label of the caracteristic.</td></tr>
                                        <tr><td>min</td><td>String</td><td>The minimum value of the caracteristic.</td></tr>
                                        <tr><td>max</td><td>String</td><td>The maximum value of the caracteristic.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="caracteristicmodified">
                                    <h2 class="page-header">CaracteristicModified</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>A <code>caracteristicmodified</code> is an override of a <code>caracteristic</code> label for a specific <code>portage</code></dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>caracteristicmodified</code></span></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>caracteristic</td><td>Object</td><td>The referenced <code>caracteristic</code> this entity is overriding.</tr>
                                        <tr><td>label</td><td>Null/String</td><td>If <code>null</code>, the the label has not been overridden.</td></tr>
                                        <tr><td>portage</td><td>Integer</td><td>The ID of the <code>portage</code> using this entity.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="gamesystem">
                                    <h2 class="page-header">GameSystem</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>A set of caracteristics and basic informations about a game set of rules.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>gamesystem</code></span></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>name</td><td>String</td><td>The entity full name</td></tr>
                                        <tr><td>shortName</td><td>String</td><td>The entity short name</td></tr>
                                        <tr><td>url</td><td>String</td><td>If the System has a website, it will provided in this field.</td></tr>
                                        <tr><td>media</td><td>String</td><td>The address of a description image, within our image repository.</td></tr>
                                        <tr><td>portageList</td><td>Array</td><td>In complete mode, a list of <code>portage</code> entities, otherwise the list of their IDs.</td></tr>
                                        <tr><td>caracteristicList</td><td>Array</td><td>In complete mode, a list of <code>caracteristic</code> entities, otherwise the list of their IDs.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="persona">
                                    <h2 class="page-header">Persona</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>The representation of a RPG character.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>persona</code></span></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>owner</td><td>Integer</td><td>A reference to the User who created the persona</td></tr>
                                        <tr><td>isPublic</td><td>Boolean</td><td>Defines if the persona can be used by other people or not.</td></tr>
                                        <tr><td>firstName</td><td>String</td><td>The persona first name.</td></tr>
                                        <tr><td>lastName</td><td>String</td><td>The persona last name.</td></tr>
                                        <tr><td>lastUpdate</td><td>Timestamp</td><td>The moment of the last update.</td></tr>
                                        <tr><td>creationTime</td><td>Timestamp</td><td>The moment of the creation.</td></tr>
                                        <tr><td>media</td><td>String</td><td>The address of a description image, within our image repository.</td></tr>
                                        <tr><td>type</td><td>Integer</td><td>A reference to the <code>personatype</code> used by this entity.</td></tr>
                                        <tr><td>portage</td><td>Integer</td><td>A reference to the <code>portage</code> used by this entity.</td></tr>
                                        <tr><td>gender</td><td>String</td><td>The gender of the persona.<br/>Actually authorized values are : "female","male","other","transgender","undefined".</td></tr>
                                        <tr><td>caracteristicList</td><td>Array</td><td>In complete mode, a list of <code>personacaracteristic</code> entities, otherwise the list of their IDs.</td></tr>
                                        <tr><td>description</td><td>String</td><td>A description of the persona, its background.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="personacaracteristic">
                                    <h2 class="page-header">PersonaCaracteristic</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>The application of a <code>caracteristicmodified</code> for a <code>persona</code>.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>personacaracteristic</code></span></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>value</td><td>String</td><td>The value applied to this <code>caracteristicmodified</code> by this <code>persona</code>.</td></tr>
                                        <tr><td>caracteristicMiD</td><td>Integer/Object</td><td>A reference towards the <code>caracteristicmodified</code> used, or an Object representing it in complete mode.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="personatype">
                                    <h2 class="page-header">PersonaType</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>The jobs and/or classes in use inside a <code>universe</code>.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>personatype</code></span></dd>
                                    </dl>
                                    <h3>Attributes</h3>
                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>id</td><td>Integer</td><td>The entity identifier</td></tr>
                                        <tr><td>name</td><td>String</td><td>The name of the job/class.</td></tr>
                                        <tr><td>universe</td><td>Integer</td><td>A reference towards the <code>universe</code>.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="portage"></div>
                                <div role="tabpanel" class="tab-pane" id="universe"></div>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                            <ul class="nav nav-pills nav-stacked" role="tablist">
                                <li role="presentation" class="active"><a href="#about" aria-controls="home" role="tab" data-toggle="tab">About</a></li>
                                <li role="presentation"><a href="#apiOverview" aria-controls="apiOverview" role="tab" data-toggle="tab">The API</a></li>
                                <li role="presentation"><a href="#entities" aria-controls="entities" role="tab" data-toggle="tab">Entities overview</a></li>
                                <li role="presentation"><a href="#caracteristic" aria-controls="caracteristic" role="tab" data-toggle="tab">Entity : Caracteristic</a></li>
                                <li role="presentation"><a href="#caracteristicmodified" aria-controls="caracteristicmodified" role="tab" data-toggle="tab">Entity : CaracteristicModifed</a></li>
                                <li role="presentation"><a href="#gamesystem" aria-controls="gamesystem" role="tab" data-toggle="tab">Entity : GameSystem</a></li>
                                <li role="presentation"><a href="#persona" aria-controls="persona" role="tab" data-toggle="tab">Entity : Persona</a></li>
                                <li role="presentation"><a href="#personacaracteristic" aria-controls="personacaracteristic" role="tab" data-toggle="tab">Entity : PersonaCaracteristic</a></li>
                                <li role="presentation"><a href="#personatype" aria-controls="personatype" role="tab" data-toggle="tab">Entity : PersonaType</a></li>
                                <li role="presentation"><a href="#portage" aria-controls="portage" role="tab" data-toggle="tab">Entity : Portage</a></li>
                                <li role="presentation"><a href="#universe" aria-controls="universe" role="tab" data-toggle="tab">Entity : Universe</a></li>
                            </ul>
                        </div>
                    </div>
                </main>
                <header class="row">
                    <div class="col-xs-12">
                        <h1 class="center">Server is active, you can now use the API</h1>
                    </div>
                </header>
                <section class="row">
                    <div class="col-xs-offset-2 col-xs-8">
                        <h3 class="page-header">Callable entites</h3>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>caracteristic</samp></b></header>
                            <div class="col-xs-8">
                                <p>A <code>gamesystem</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>caracteristicmodified</samp></b></header>
                            <div class="col-xs-8">
                                <p>Extending <code>caracteristic</code>, it is a <code>portage</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>gamesystem</samp></b></header>
                            <div class="col-xs-8">
                                <p>A base entity, describing a RPG system.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>human</samp></b></header>
                            <div class="col-xs-8">
                                <p>A base entity, representing a user.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>media</samp></b></header>
                            <div class="col-xs-8">
                                <p>A base entity, representing an image uploaded on the server.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>personacaracteristic</samp></b></header>
                            <div class="col-xs-8">
                                <p>A <code>persona</code> sub-entity, representing the value of a <code>personacaracteristic</code>, for this <code>persona</code>.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>persona</samp></b></header>
                            <div class="col-xs-8">
                                <p>The representation of a RPG <code>persona</code>, inside an <code>universe</code>, and within a <code>gamesystem</code>.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>personatype</samp></b></header>
                            <div class="col-xs-8">
                                <p>The <em>Class</em> of a <code>persona</code> in an <code>universe</code>.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>portage</samp></b></header>
                            <div class="col-xs-8">
                                <p>The application of a <code>gamesystem</code> for an <code>universe</code>.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>universe</samp></b></header>
                            <div class="col-xs-8">
                                <p>A base entity, representing some informations about a RPG Universe.</p>
                            </div>
                        </article>
                    </div>
                    <div class="col-xs-offset-2 col-xs-8">
                        <h3 class="page-header">Possible routes</h3>
                        <article class="row">
                            <div class="col-xs-12">
                                <p>All requests are presented : as <em><b>[HTTP VERB] [route]</b> [description]</em>.</p>
                                <p>All reponses are Json object, structured as <samp>{"requestDate":0,"response":[],"error":[]}"</samp> where <samp>requestDate</samp> is the timestamp of your request, <samp>response</samp> an array containing your responsen and <samp>error</samp> an array all errors encounterd during the process.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>GET /api/:entity/:id[/complete] </samp></b></header>
                            <div class="col-xs-8">
                                <p>Returns an entity with the specified identifier.</p>
                                <p><samp>entity</samp> is one of the keys given in the <em>callable</em> entity.</p>
                                <p><samp>id</samp> is the identifier of the ressource you want to access.</p>
                                <p><samp>complete</samp> is optional. If mentioned, and if the entity has list inside, all listed entities will be given as complete objects, and as lists of IDs instead.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>GET /api/:entity/all</samp></b></header>
                            <div class="col-xs-8">
                                <p>Returns the list of all entities of the given type.</p>
                                <p><samp>entity</samp> is one of the keys given in the <em>callable</em> entity.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>POST /api/:entity</samp></b></header>
                            <div class="col-xs-8">
                                <p>Creates an entity with the specified attributes sent.</p>
                                <p><samp>entity</samp> is one of the keys given in the <em>callable</em> entity.</p>
                                <p>TODO : List all attributes possible per entity.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>POST /api/:entity/:id}</samp></b></header>
                            <div class="col-xs-8">
                                <p>Updates an entity with the specified attributes sent.</p>
                                <p><samp>entity</samp> is one of the keys given in the <em>callable</em> entity.</p>
                                <p>TODO : List all allowed attributes per entity.</p>
                            </div>
                        </article>
                        <article class="row">
                            <header class="col-xs-4"><b><samp>DELETE /api/:entity/:id</samp></b></header>
                            <div class="col-xs-8">
                                <p>Deletes an entity with the specified attributes sent.</p>
                                <p><samp>entity</samp> is one of the keys given in the <em>callable</em> entity.</p>
                            </div>
                        </article>
                    </div>
                </section>
            </main>
    </body>
</html>