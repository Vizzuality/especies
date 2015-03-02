
     <div class="col-sm-3 col-md-2 sidebar">
       <ul class="nav nav-sidebar">
         <li class="${controllerName == "dashboard" ? "active" : "" }">
           <g:link controller="dashboard" action="index">Dashboard</g:link>
          </li>
         <li class="${controllerName == "taxa" ? "active" : "" }">
           <g:link controller="taxa" action="index">Species</g:link>
         </li>
         <li class="${controllerName == "distributions" ? "active" : "" }">
           <g:link controller="distributions" action="index">Distributions</g:link>
         </li>
       </ul>
     </div>