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
	 <g:paginate controller="distributions" action="index" total="${distributionsCount}" max="50"
	    params="${params}"/>
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
	      <th>Species</th>
          <th>Type</th>
	      <th>Region</th>
          <th>Other</th>
      </tr>
    </thead>
    <tbody>
      <g:each in="${distributions}" var="d">
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