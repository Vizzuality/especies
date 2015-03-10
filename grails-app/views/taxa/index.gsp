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
    <h1>Species <asset:image src="spinner.gif" alt="spinner" class="hide spinner" /></h1>

	    <g:form url="[action:'index']" class="form-inline" method="get">
	      <p>
			 <div class="form-group">
                 <div class="radio">
                     <label>
                    <input type="radio" name="collection" id="all" value="all"
                     ${!params.collection || params.collection == "all" ? "checked" : ""}>
                      Search in all species
                  </label>
                </div>
                <div class="radio">
                  <label>
                      <input type="radio" name="collection" id="noMatches" value="noMatches"
                          ${params.collection == "noMatches" ? "checked" : ""}>
                      No Matches
                  </label>
                </div>
	          <div class="radio">
	            <label>
	              <input type="radio" name="collection" id="speciesplus" value="speciesplus"
	               ${params.collection == "speciesplus" ? "checked" : ""}>
	                Species+
	            </label>
	          </div>
	          <div class="radio">
	            <label>
	              <input type="radio" name="collection" id="gbif" value="gbif"
	               ${params.collection == "gbif" ? "checked" : ""}>
	                GBIF
	            </label>
	          </div>
            </div>
        </p>
        <p>
            <div class="form-group">
                <div class="radio">
                    <label>
                        <input type="radio" name="nameStatus" id="all" value="all"
                            ${!params.nameStatus || params.nameStatus == "all" ? "checked" : ""}>
                        All status
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="nameStatus" id="accepted" value="accepted"
                            ${params.nameStatus == "accepted" ? "checked" : ""}>
                        Accepted
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="nameStatus" id="synonyms" value="synonyms"
                            ${params.nameStatus == "synonyms" ? "checked" : ""}>
                        Synonyms
                    </label>
                </div>
            </div>
        </p>
        <p>
            <div class="form-group">
		        <g:textField class="form-control input-fullsize" name="query"
		         value="${params.query}"  placeholder="Search taxa"/>
		       </div>
		       <g:submitButton name="submit" value="Search" class="btn btn-default"/>
	    </p>
	    </g:form>
        <button id="importBrazil" class="btn btn-info">
            Import Data
        </button>

    <hr>
	<g:paginate controller="taxa" action="index" total="${taxaCount}" max="50"
	   params="${params}"/>
    <table id="taxa-table" class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>id</th>
                <th>Kingdom</th>
                <th>Phylum</th>
                <th>Order</th>
                <th>Class</th>
                <th>Family</th>
                <th>Scientific Name</th>
                <th>Name status</th>
                <th>Brazil's id</th>
                <th>Species+ id</th>
                <th>CITES Listing</th>
                <th>GBIF id</th>
                <th>GBIF name</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${taxa}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.kingdomName}</td>
                    <td>${s.phylumName}</td>
                    <td>${s.orderName}</td>
                    <td>${s.className}</td>
                    <td>${s.familyName}</td>
                    <td>${s.scientificName}</td>
                    <td>${s.nameStatus}</td>
                    <td>${s.sourceId}</td>
                    <td>${s.speciesPlusId}</td>
                    <td>${s.citesListing}</td>
                    <td>${s.gbifId }</td>
                    <td>${s.gbifName}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
