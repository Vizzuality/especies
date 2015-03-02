<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main">
</head>


<body>
  <h1>Dashboard</h1>
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>Database</th>
        <th>Last update</th>
        <th>Total records</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
       <g:each in="${stats}" var="s">
        <tr>
          <td>${s.getValue().title}</td>
          <td></td>
          <td>${s.getValue().total}</td>
          <td></td>
        </tr>
       </g:each>
    </tbody>
  </table>
  
  <h2>Other data</h2>
    <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>Type</th>
        <th>Last update</th>
        <th>Total records</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
       <g:each in="${auxStats}" var="s">
        <tr>
          <td>${s.getValue().title}</td>
          <td></td>
          <td>${s.getValue().total}</td>
          <td></td>
        </tr>
       </g:each>
    </tbody>
  </table>
</body>