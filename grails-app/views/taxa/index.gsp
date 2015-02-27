<%--
  Created by IntelliJ IDEA.
  User: Simao
  Date: 17/02/15
  Time: 11:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main">
</head>

<body>
    <h1>Taxonify <asset:image src="spinner.gif" alt="spinner" class="hide spinner" /></h1>
    <p>
	    <g:form url="[action:'index']" class="form-inline" method="get">
		    <div class="form-group">
	        <button id="importBrazil" class="btn btn-info">
	         Import Data
	        </button>
	        <g:textField class="form-control input-fullsize" name="query"
	         value="${params.query}" required="required"
	         placeholder="Search taxa"/>
	       </div>
	       <g:submitButton name="submit" value="Search" class="btn btn-default"/>
	    </g:form>
    </p>

    <hr>
	<g:paginate controller="taxa" action="index" total="${taxaCount}" max="50" />
    <table id="taxa-table" class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>Kingdom</th>
                <th>Phylum</th>
                <th>Order</th>
                <th>Class</th>
                <th>Family</th>
                <th>Scientific Name</th>
                <th>Name status</th>
                <th>Brazil's id</th>
                <th>Species+ id</th>
                <th>GBIF id</th>
                <th>GBIF name</th>
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
                    <td>${s.nameStatus}</td>
                    <td>${s.sourceId}</td>
                    <td>${s.speciesPlusId}</td>
                    <td>${s.gbifId }</td>
                    <td>${s.gbifName}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
