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
    <h1>Search some species</h1>
    <g:form url="[action:'index']" class="form-inline" method="get">
        <div class="form-group">
            <g:textField class="form-control input-fullsize" name="query" value="${params.query}" required="required" />
        </div>
        <g:submitButton name="submit" value="Search" class="btn btn-default"/>
    </g:form>

    <hr>

    <table class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>Source id</th>
                <th>Kingdom</th>
                <th>Phylum</th>
                <th>Order</th>
                <th>Class</th>
                <th>Family</th>
                <th>Genus</th>
                <th>Scientific Name</th>
                <th>Source</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${taxa}" var="s">
                <tr>
                    <td>${s.sourceId}</td>
                    <td>${s.kingdomName}</td>
                    <td>${s.phylumName}</td>
                    <td>${s.orderName}</td>
                    <td>${s.className}</td>
                    <td>${s.familyName}</td>
                    <td>${s.genusName}</td>
                    <td>${s.scientificName}</td>
                    <td class="${s.source == 'Species+' ? "info" : "success"}">
                        ${s.source}
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
