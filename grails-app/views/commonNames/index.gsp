<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main">
</head>

<body>
    <h1>Common Names <asset:image src="spinner.gif" alt="spinner" class="hide spinner" /></h1>
    <p>
        <button id="importCommonNames" class="btn btn-info">
            Import Common Names
        </button>
    </p>
    <g:paginate controller="commonNames" action="index" total="${commonNamesCount}" max="50"
                params="${params}"/>
    <table class="table table-bordered table-condensed">
        <thead>
        <tr>
            <th>Species</th>
            <th>Type</th>
            <th>Value</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${commonNames}" var="d">
            <tr>
                <td>${d.taxon.scientificName }</td>
                <td>${d.type}</td>
                <td>${d.value}</td>
                <td>${d.data}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</body>