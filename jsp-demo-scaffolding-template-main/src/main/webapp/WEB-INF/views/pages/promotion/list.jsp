<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="scaffold.framework.demo.entity.Promotion" %>
<html>
<jsp:include page="../../templates/header.jsp">
    <jsp:param name="title" value="Promotion list"/>
</jsp:include>
<body>
    <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
        <%@ include file="../../templates/nav.jsp" %>
        <div class="body-wrapper">
            <%@ include file="../../templates/app-header.jsp" %>
            <div class="container-fluid">
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title fw-semibold mb-4">All promotion</h5>
                            <div class="card w-100">
                                <div class="card-body p-4">
                                    <div class="table-responsive">
                                        <table class="table text-nowrap mb-0 align-middle">
                                            <thead class="text-dark fs-4">
                                                <tr>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Id</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Name</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Year</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Actions</h6>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Promotion> promotions = (List<Promotion>) request.getAttribute("promotions");
                                                for (Promotion promotion : promotions) { %>
                                                    <tr>
                                                        <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%= promotion.getId() %></h6></td>
                                                        <td class="border-bottom-0"><%= promotion.getName() %></td>
                                                        <td class="border-bottom-0"><%= promotion.getYear() %></td>
                                                        <td>
                                                            <a href="/promotions/edit/<%= promotion.getId() %>">Edit</a> |
                                                            <a href="/promotions/delete/<%= promotion.getId() %>">Delete</a>
                                                        </td>
                                                    </tr>
                                                <% } %>                   
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <a href="/promotions/add">Add New Promotion</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../templates/main-footer.jsp" %>
    <%@ include file="../../templates/page-footer.jsp" %>
</body>
</html>