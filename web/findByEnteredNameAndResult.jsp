<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Find by entered name of exam and result</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/findByNameAndResult" method="get">
    <legend>Find by entered name of exam and result</legend>
    <fieldset>
        <label for="nameOfExam">Enter name of exam:</label>
        <input type="text" name="nameOfExam">
        <label for="result">Enter result:</label>
        <input type="text" name="result">
    </fieldset>
    <button type="submit" class="find">Find</button>

</form>
<p style="color: red;">${errorString}</p>
<form>
    <table border align="center">
        <c:if test="${list!= null}">
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Surname</th>
                <th>Passport code</th>
                <th>Certificate code</th>
                <th>Name of the first exam</th>
                <th>Result of the first exam</th>
                <th>Name of the second exam</th>
                <th>Result of the second exam</th>
                <th>Name of the third exam</th>
                <th>Result of the third exam</th>
                <th>University</th>
                <th>Faculty</th>
                <th>Speciality</th>
                <th>Average mark of the certificate</th>
                <th>Rural coefficient</th>
                <th></th>
                <th></th>
            </tr>
        </c:if>
        <c:forEach items="${list}" var="applicant">
            <tr>
                <td>${applicant.firstName}</td>
                <td>${applicant.lastName}</td>
                <td>${applicant.surname}</td>
                <td>${applicant.passportCode}</td>
                <td>${applicant.certificateCode}</td>
                <td>${applicant.exam.firstExam.nameOfExam}</td>
                <td>${applicant.exam.firstExam.result}</td>
                <td>${applicant.exam.secondExam.nameOfExam}</td>
                <td>${applicant.exam.secondExam.result}</td>
                <td>${applicant.exam.thirdExam.nameOfExam}</td>
                <td>${applicant.exam.thirdExam.result}</td>
                <td>${applicant.speciality.university}</td>
                <td>${applicant.speciality.faculty}</td>
                <td>${applicant.speciality.speciality}</td>
                <td>${applicant.averangeMarkOfTheCertificate}</td>
                <td>${applicant.ruralCoef}</td>
                <td><a href="/update?id=${applicant.id}"><img src="img/edit.png" alt="Edit" width="15" height="15"
                                                              title="Edit"></a></td>
                <td><a href="/delete?id=${applicant.id}"><img src="/img/delete.png" alt="Delete" width="15" height="15"
                                                              title="Delete"></a></td>
            </tr>
        </c:forEach>
    </table>
    </fieldset>
    <fieldset>
        <a href="/index.jsp">
            <button type="button">Back</button>
        </a>
    </fieldset>
</form>
</body>
</html>