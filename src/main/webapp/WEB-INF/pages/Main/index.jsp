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
        <style>
            main {
                display : table-cell;
                width: 100vw;
                height: 100vh;
                vertical-align: middle;
            }
            .center { text-align: center}
        </style>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <body>
        <main class="container-fluid">
            <header class="row">
                <div class="col-xs-12">
                    <h1 class="center">Server is active, you can now use the API</h1>
                </div>
            </header>
            <section class="row">
                <div class="col-xs-offset-2 col-xs-8">
                    <h3 class="page-header">Callable entites</h3>
                    <article class="row">
                        <header class="col-xs-4"><pre>caracteristic</pre></header>
                        <div class="col-xs-8">
                            <p>A <code>gamesystem</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>caracteristicmodified</pre></header>
                        <div class="col-xs-8">
                            <p>Extending <code>caracteristic</code>, it is a <code>portage</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>gamesystem</pre></header>
                        <div class="col-xs-8">
                            <p>A base entity, describing a RPG system.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>human</pre></header>
                        <div class="col-xs-8">
                            <p>A base entity, representing a user.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>media</pre></header>
                        <div class="col-xs-8">
                            <p>A base entity, representing an image uploaded on the server.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>personacaracteristic</pre></header>
                        <div class="col-xs-8">
                            <p>A <code>persona</code> sub-entity, representing the value of a <code>personacaracteristic</code>, for this <code>persona</code>.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>persona</pre></header>
                        <div class="col-xs-8">
                            <p>The representation of a RPG <code>persona</code>, inside an <code>universe</code>, and within a <code>gamesystem</code>.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>personatype</pre></header>
                        <div class="col-xs-8">
                            <p>The <em>Class</em> of a <code>persona</code> in an <code>universe</code>.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>portage</pre></header>
                        <div class="col-xs-8">
                            <p>The application of a <code>gamesystem</code> for an <code>universe</code>.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-4"><pre>universe</pre></header>
                        <div class="col-xs-8">
                            <p>A base entity, representing some informations about a RPG Universe.</p>
                        </div>
                    </article>
                </div>
            </section>
        </main>
    </body>
</html>