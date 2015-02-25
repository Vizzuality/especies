<%--
  Created by IntelliJ IDEA.
  User: Simao
  Date: 17/02/15
  Time: 11:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main">
    <title>Species Index</title>
</head>

<body>
    <h1>Taxonify</h1>
    <p>
    	<button id="importBrazil" class="btn btn-info">Import Brazil's data</button>
    	<button id="addSpeciesPlus" class="btn btn-info" disabled="disabled">
    		Add Species Plus IDs</button>
    	<button id="linkToGbif" class="btn btn-info" disabled="disabled">Link GBIF data</button>
    </p>
    <g:form url="[action:'index']" class="form-inline" method="get">
        <div class="form-group">
            <g:textField class="form-control input-fullsize" name="query" value="${params.query}" required="required" />
        </div>
        <g:submitButton name="submit" value="Search" class="btn btn-default"/>
    </g:form>

    <hr>

    <table id="taxa-table" class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>Kingdom</th>
                <th>Phylum</th>
                <th>Order</th>
                <th>Class</th>
                <th>Family</th>
                <th>Scientific Name</th>
                <th>Brazil's id</th>
                <th>Species+ id</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${taxa}" var="s">
                <tr>
                    <td>${s.kingdomName}</td>
                    <td>${s.phylumName}</td>
                    <td>${s.orderName}</td>
                    <td>${s.className}</td>
                    <td>${s.familyName}</td>
                    <td>${s.scientificName}</td>
                    <td>${s.sourceId}</td>
                    <td>${s.speciesPlusId}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
