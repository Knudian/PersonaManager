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
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <!--[if IE]><link rel="shortcut icon" href="/resources/img/favicon.ico"/><![endif]-->
        <link rel="icon" href="/resources/img/favicon.png"/>
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
                        <p>A course project built with passion by :</p>
                        <ul>
                            <li><a href="https://github.com/Fubuke" target="_blank">@Fubuke</a></li>
                            <li><a href="https://github.com/Knudian" target="_blank">@Knudian</a></li>
                        </ul>
                        <p>
                            Current version : <code>1.0.0-alpha1</code>
                        </p>
                        <p>
                            <a class="btn btn-sm btn-block btn-default" target="_blank" href="https://github.com/Knudian/PersonaManager/tree/master">Project Homepage</a>
                        </p>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-xs-4 col-xs-offset-4">
                            <img class="img-responsive" src="/resources/img/logo.svg" alt="Persona Manager Logo"/>
                        </div>
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
                                    <p>A less as possible datas are stored. So, the application does not calculate anything. It just stores data.</p>
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
                                    <h4 class="page-header">API's response</h4>
                                    <p>The API is JSON based, so you will always have a HTTP 200 code for each request, except in case of server failure.</p>
                                    <p>The response is always structured in the same way :</p>
<pre>{
    "requestTime": 0,
    "response": [],
    "errors": []
}</pre>
                                    <p><code>requestTime</code> is a Timestamp value indicating the moment the server sent back a response.</p>
                                    <p><code>response</code> is an array containing the request content.</p>
                                    <p><code>errors</code> is an array containing your request errors. Let's hope you won't have any.</p>
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="caracteristicmodified">
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="gamesystem">
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="persona">
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="personacaracteristic">
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="personatype">
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
                                <div role="tabpanel" class="tab-pane table-responsive" id="portage">
                                    <h2 class="page-header">Portage</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>The application of a <code>gamesystem</code> on a <code>universe</code>.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>portage</code></span></dd>
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
                                        <tr><td>universe</td><td>Integer</td><td>A reference towards the <code>universe</code>.</td></tr>
                                        <tr><td>gamesystem</td><td>Integer</td><td>A reference towards the <code>gamesystem</code>.</td></tr>
                                        <tr><td>creationTime</td><td>Timestamp</td><td>The moment of the creation.</td></tr>
                                        <tr><td>personaList</td><td>Array</td><td>The list of <code>persona</code> created with this <code>portage</code></td></tr>
                                        <tr><td>caracteristicList</td><td>Array</td><td>The list of <code>caracteristicmodified</code> to use with this <code>portage</code>.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane table-responsive" id="universe">
                                    <h2 class="page-header">Universe</h2>
                                    <h3>Informations</h3>
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>Definition of a <code>universe</code> in the application.</dd>
                                        <dt>Keyword</dt>
                                        <dd><span><code>universe</code></span></dd>
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
                                        <tr><td>name</td><td>String</td><td>The universe name</td></tr>
                                        <tr><td>description</td><td>String</td><td>The universe description</td></tr>
                                        <tr><td>media</td><td>String</td><td>The address of a description image, within our image repository.</td></tr>
                                        <tr><td>creationTime</td><td>Timestamp</td><td>The moment of the creation.</td></tr>
                                        <tr><td>portageList</td><td>Array</td><td>The list of <code>portage</code> using this <code>universe</code>.</td></tr>
                                        <tr><td>personaTypeList</td><td>Array</td><td>The list of <code>personaType</code> that can be used.</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane table-responsive" id="routeCreation">
                                    <h2 class="page-header">Route for creating entities</h2>
                                    <pre>POST /api/:keyword</pre>
                                    <p>Change the <code>:keyword</code> to any of provided ones.</p>
                                    <p>As a response, you will get the result of a GET on your freshly created entity.</p>
                                    <h4 class="page-header">Required attributes per entity</h4>
                                    <p>The <code>media</code> is always optional.</p>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr><td>Entity keyword</td><td>Attributes</td></tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>caracteristic</td><td>gamesystem, defaultLabel, type, min, max</td></tr>
                                        <tr><td>caracteristicmodified</td><td>caracteristic, label</td></tr>
                                        <tr><td>gamesystem</td><td>name, shortName, url, media</td></tr>
                                        <tr><td>persona</td><td>type, owner, isPublic, firstName, lastName, description, gender, portage</td></tr>
                                        <tr><td>personatype</td><td>name, universe</td></tr>
                                        <tr><td>portage</td><td>gamesystem, universe</td></tr>
                                        <tr><td>universe</td><td>name, description, media</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div role="tabpanel" class="tab-pane" id="routeGet">
                                    <h2 class="page-header">Route for getting an entity</h2>
                                    <pre>GET /api/:keyword/:id/complete</pre>
                                    <p>Change the <code>:keyword</code> to any of provided ones.</p>
                                    <p>Change the <code>:id</code> to the identifier value of the entity you want.</p>
                                    <p>The <code>/complete</code> part is optionnal. Using it will, in most cases, load a "not complete" representation of any linked entity within the one you want.</p>
                                    <p>Replace <code>/complete</code> by <code>/all</code> to get a list of all publicly available entity of the requested type.</p>
                                </div>
                                <div role="tabpanel" class="tab-pane table-responsive" id="routeUpdate">
                                    <h2 class="page-header">Route for updating entities</h2>
                                    <pre>POST /api/:keyword/:id</pre>
                                    <p>Change the <code>:keyword</code> to any of provided ones.</p>
                                    <p>Change the <code>:id</code> to the identifier value of the entity you want to update.</p>
                                    <p>As a response, you will get the result of a GET on your freshly updated entity.</p>
                                    <h4 class="page-header">Authorized attributes per entity</h4>
                                    <p>All fields are optional, so you can send a post request, with just the id, even it's useless in itself.</p>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr><td>Entity keyword</td><td>Attributes</td></tr>
                                        </thead>
                                        <tbody>
                                        <tr><td>caracteristic</td><td>defaultLabel, type, min, max</td></tr>
                                        <tr><td>caracteristicmodified</td><td>label</td></tr>
                                        <tr><td>gamesystem</td><td>name, shortName, url, media</td></tr>
                                        <tr><td>persona</td><td>type, isPublic, firstName, lastName, description, gender</td></tr>
                                        <tr><td>personatype</td><td>name</td></tr>
                                        <tr><td>universe</td><td>name, description, media</td></tr>
                                        </tbody>
                                    </table>

                                </div>
                                <div role="tabpanel" class="tab-pane" id="routeDelete">
                                    <h2 class="page-header">Route for deleting an entity</h2>
                                    <pre>DELETE /api/:keyword/:id</pre>
                                    <p>Change the <code>:keyword</code> to any of provided ones.</p>
                                    <p>We use a data-cascade to delete related entities.</p>
                                    <p>As a response, you will get a boolean value validating or not your request.</p>
                                    <p>Change the <code>:id</code> to the identifier value of the entity you want.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                            <ul class="nav nav-pills nav-stacked" role="tablist">
                                <li role="presentation" class="active"><a href="#about" aria-controls="home" role="tab" data-toggle="tab">About</a></li>
                                <li role="presentation"><a href="#apiOverview" aria-controls="apiOverview" role="tab" data-toggle="tab">The API</a></li>
                                <!-- The Entities description buttons -->
                                <li role="presentation"><a href="#entities" aria-controls="entities" role="tab" data-toggle="tab">Entities overview</a></li>
                                <li role="presentation"><a href="#caracteristic" aria-controls="caracteristic" role="tab" data-toggle="tab">Entity : Caracteristic</a></li>
                                <li role="presentation"><a href="#caracteristicmodified" aria-controls="caracteristicmodified" role="tab" data-toggle="tab">Entity : CaracteristicModifed</a></li>
                                <li role="presentation"><a href="#gamesystem" aria-controls="gamesystem" role="tab" data-toggle="tab">Entity : GameSystem</a></li>
                                <li role="presentation"><a href="#persona" aria-controls="persona" role="tab" data-toggle="tab">Entity : Persona</a></li>
                                <li role="presentation"><a href="#personacaracteristic" aria-controls="personacaracteristic" role="tab" data-toggle="tab">Entity : PersonaCaracteristic</a></li>
                                <li role="presentation"><a href="#personatype" aria-controls="personatype" role="tab" data-toggle="tab">Entity : PersonaType</a></li>
                                <li role="presentation"><a href="#portage" aria-controls="portage" role="tab" data-toggle="tab">Entity : Portage</a></li>
                                <li role="presentation"><a href="#universe" aria-controls="universe" role="tab" data-toggle="tab">Entity : Universe</a></li>
                                <!-- The Routes description -->
                                <li role="presentation"><a href="#routeCreation" aria-controls="routeCreation" role="tab" data-toggle="tab">Route : Create an entity</a></li>
                                <li role="presentation"><a href="#routeGet" aria-controls="routeGet" role="tab" data-toggle="tab">Route : Get an entity</a></li>
                                <li role="presentation"><a href="#routeUpdate" aria-controls="routeUpdate" role="tab" data-toggle="tab">Route : Update an entity</a></li>
                                <li role="presentation"><a href="#routeDelete" aria-controls="routeDelete" role="tab" data-toggle="tab">Route : Delete an entity</a></li>
                            </ul>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
