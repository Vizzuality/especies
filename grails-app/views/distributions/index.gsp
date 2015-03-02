<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main">
</head>

<body>
  <h1>Distributions <asset:image src="spinner.gif" alt="spinner" class="hide spinner" /></h1>
  <p>
    <button id="importDistributions" class="btn btn-info">
      Import Distributions
    </button>
	 </p>
	 <g:paginate controller="distribution" action="index" total="${distributionsCount}" max="50"
	    params="${params}"/>
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
	      <th>Species</th>
	      <th>Region</th>
      </tr>
    </thead>
    <tbody>
      <g:each in="${distributions}" var="d">
        <tr>
          <td>${d.taxon.scientificName }</td>
          <td>${d.geoEntity.isoCode}</td>
        </tr>
      </g:each>
    </tbody>
  </table>
</body>