<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Map" %>
<%
Map<String,String> errors=(Map<String,String>) request.getAttribute("errors");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
<h3>User Form</h3>
<%
if(errors!=null&&errors.size()>0){

%>
<ul>
<% for(String e:errors.values()){ %>
<li><%=e%></li>
<% } %>
</ul>
<% } %>

    <form action="/Section41JAVAMaster/register" method="post">

        <div>
            <label for="username">User</label>
            <div><input type="text" name="username" id="username" value="${param.user}"></div>
            <%
            if(errors!=null&&errors.containsKey("user")){
                out.println("<small style='color:red;'>"+errors.get("user")+"</small>");
            }
            %>
        </div>
        <div>
            <label for="pass">Password</label>
            <div><input type="password" name="pass" id="pass"></div>
             <%
                        if(errors!=null&&errors.containsKey("pass")){
                            out.println("<small style='color:red;'>"+errors.get("pass")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label for="email">Email</label>
            <div><input type="text" name="email" id="email" value="${param.email}"></div>
             <%
                        if(errors!=null&&errors.containsKey("email")){
                            out.println("<small style='color:red;'>"+errors.get("email")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label for="country">Country</label>
            <div>
            <select name="country" id="country">
                <option value="">--Select--</option>
                <option value="SP" ${param.country.equals("SP")?"selected":""}>Spain</option>
                <option value="CL" ${param.country.equals("CL")?"selected":""}>Chile</option>
                <option value="USA" ${param.country.equals("USA")?"selected":""}>United States</option>
            </select>
            </div>
             <%
                        if(errors!=null&&errors.containsKey("country")){
                            out.println("<small style='color:red;'>"+errors.get("country")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label for="language">Programming Language</label>
            <div>
                <select name="language" id="language" multiple>
                    <option value="java" ${paramValues.language
                    .stream().anyMatch(v->v.equals("java")).get()?"selected":""}>JAVA SE</option>
                    <option value="js" ${paramValues.language
                     .stream().anyMatch(v->v.equals("js")).get()?"selected":""}>JavaScript</option>
                    <option value="spring" ${paramValues.language
                     .stream().anyMatch(v->v.equals("spring")).get()?"selected":""}>Spring FrameWork</option>
                </select>
            </div>
             <%
                        if(errors!=null&&errors.containsKey("language")){
                            out.println("<small style='color:red;'>"+errors.get("language")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label >Roles</label>
            <div>
                <input type="checkbox" name="roles" value="ROLE_ADM"
                ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_ADM")).get()?"checked":""}
                >
                <label>Admin</label>
            </div>
            <div>
                <input type="checkbox" name="roles"  value="ROLE_USER"
                 ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_USER")).get()?"checked":""}
                >
                <label>User</label>
            </div>
            <div>
                <input type="checkbox" name="roles"  value="ROLE_MOD"
                 ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_MOD")).get()?"checked":""}
                >
                <label>Moderator</label>
            </div>
             <%
                        if(errors!=null&&errors.containsKey("role")){
                            out.println("<small style='color:red;'>"+errors.get("role")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label>Language</label>
            <div>
                <input type="radio" name="lang" value="sp" ${param.lang.equals("sp")?"checked":""}>
                <label>Spanish</label>
            </div>
            <div>
                <input type="radio" name="lang" value="ch" ${param.lang.equals("ch")?"checked":""}>
                <label>Chinese</label>
            </div>
            <div>
                <input type="radio" name="lang" value="en" ${param.lang.equals("en")?"checked":""}>
                <label>English</label>
            </div>
             <%
                        if(errors!=null&&errors.containsKey("lang")){
                            out.println("<small style='color:red;'>"+errors.get("lang")+"</small>");
                        }
                        %>
        </div>
        <div>
            <label for="enable">Enable</label>
            <div>
                <input type="checkbox" name="enable" id="enable" checked>
            </div>
        </div>
        <div>
            <div><input type="submit" value="Send"></div>
        </div>
        <input type="hidden" name="secret" value="123456">
    </form>

</body>
</html>