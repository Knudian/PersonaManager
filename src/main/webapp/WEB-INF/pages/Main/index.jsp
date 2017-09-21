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
                    <hr/>
                    <article class="row">
                        <header class="col-xs-12"><code>caracteristic</code></header>
                        <div class="col-xs-12">
                            <p>A <code>gamesystem</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>caracteristicmodified</code></header>
                        <div class="col-xs-12">
                            <p>Extending <code>caracteristic</code>, it is a <code>portage</code> sub-entity, representing a <code>persona</code> attribute within it.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>gamesystem</code></header>
                        <div class="col-xs-12">
                            <p>A base entity, describing a RPG system.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>human</code></header>
                        <div class="col-xs-12">
                            <p>A base entity, representing a user</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>media</code></header>
                        <div class="col-xs-12">
                            <p>A base entity, representing an image uploaded on the server.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>personacaracteristic</code></header>
                        <div class="col-xs-12">
                            <p>A <code>persona</code> sub-entity, representing the value of a <code>personacaracteristic</code>, for this <code>persona</code>.</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>persona</code></header>
                        <div class="col-xs-12">
                            <p>The representation of a RPG persona, inside an Universe, and within a GameSystem</p>
                        </div>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>personatype</code></header>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>portage</code></header>
                    </article>
                    <article class="row">
                        <header class="col-xs-12"><code>universe</code></header>
                    </article>
                </div>
            </section>
        </main>
    </body>
</html>