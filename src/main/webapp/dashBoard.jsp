<%@ page import="com.example.ohsapp.beans.UserBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>


<%

    // Hide admin button in navbar if user is not admin

    String hideAdminButton = "";
<<<<<<< HEAD
    if (session.getAttribute("user") == null) {
        UserBean userBean = (UserBean) session.getAttribute("user");
        if (!userBean.isCheckAdmin()) {
            hideAdminButton = "hidden";
=======
    if(session.getAttribute("user") !=null){
        UserBean userBean = (UserBean) session.getAttribute("user");
        if (!userBean.isCheckAdmin()) {
            hideAdminButton = "hidden";

>>>>>>> 0f87dbcedb9474a28bf1facc6df54586f2b13461
        }
    }


%>

<nav class="navbar navbar-expand-lg dash">
    <div class="container-fluid">
        <a class="navbar-brand dash" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link dash" href="/searchWindow.jsp">Sök artikel</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link dash" href="/orderWindow.jsp">Beställningar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link dash" href="/addProductsWindow.jsp">Lägg in artikel</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link dash" href="/wasteWindow.jsp">Svinn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link dash" href="/statisticsWindow.jsp">Statistik</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link dash" <%=hideAdminButton%> href="/adminWindow.jsp">Admin</a>
                </li>
            </ul>
        </div>
    </div>
</nav>