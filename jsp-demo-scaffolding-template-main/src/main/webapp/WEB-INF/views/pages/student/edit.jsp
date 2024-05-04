<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="scaffold.framework.demo.entity.Promotion" %>
<%@ page import="scaffold.framework.demo.entity.Student" %>
<html>
<jsp:include page="../../templates/header.jsp">
    <jsp:param name="title" value="Edit student"/>
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
                            <h5 class="card-title fw-semibold mb-4">Edit student</h5>
                            <% Student student = (Student) request.getAttribute("student"); %>
                            <form action="/students/edit" method="post">
                                <input type="hidden" name="id" value="<%= student.getId() %>">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name:</label>
                                    <input type="text" id="name" name="name" class="form-control" value="<%= student.getName() %>" required />
                                    <div class="form-text">For errors for example.</div>
                                </div>
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First name:</label>
                                    <input type="text" id="firstName" name="firstName" class="form-control" value="<%= student.getFirstName() %>" required />
                                </div>
                                <div class="mb-3">
                                    <label for="birthdate" class="form-label">Birthdate:</label>
                                    <input type="date" id="birthdate" name="birthdate" class="form-control" value="<%= student.getBirthdate().toString() %>" required />
                                </div>
                                <div class="mb-3">
                                    <label for="promotionId" class="form-label">Promotion:</label>
                                    <select id="promotionId" class="form-select" name="promotionId">
                                        <% List<Promotion> promotions = (List<Promotion>) request.getAttribute("promotions"); %>
                                        <option value="<%= student.getPromotion().getId() %>"><%= student.getPromotion().toString() %></option>
                                        <% for(int i = 0; i < promotions.size(); i++) { %>
                                            <option value="<%= promotions.get(i).getId() %>"><%= promotions.get(i).toString() %></option>
                                        <% } %>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Update Promotion</button>
                            </form>
                            <a href="/students/list">Back to List</a>
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