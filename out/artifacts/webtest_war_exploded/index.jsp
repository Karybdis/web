<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: sunsc
  Date: 2017/7/24
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! int day=1; %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
      <th>Header Name</th><th>Header Value(s)</th>
    </tr>
    <%
      Enumeration headerNames = request.getHeaderNames();
      while(headerNames.hasMoreElements()) {
        String paramName = (String)headerNames.nextElement();
        out.print("<tr><td>" + paramName + "</td>\n");
        String paramValue = request.getHeader(paramName);
        out.println("<td> " + paramValue + "</td></tr>\n");
      }
    %>
  </table>

  </body>
</html>
