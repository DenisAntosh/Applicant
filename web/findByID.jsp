<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Find by ID</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/findById" method="get">
    <legend>Find applicants by ID</legend>
    <fieldset>
        <label for="id">Enter id:</label>
        <input type="text" name="id">
    </fieldset>
    <button type="submit" class="find">Find</button>
</form>
<p style="color: red;">${errorString}</p>
<form>
    <table border align="center">
        <c:if test="${applicant != null}">
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
            <tr>
                <c>
                    <td>${applicant.firstName}</td>
                </c>
                <c>
                    <td>${applicant.lastName}</td>
                </c>
                <c>
                    <td>${applicant.surname}</td>
                </c>
                <c>
                    <td>${applicant.passportCode}</td>
                </c>
                <c>
                    <td>${applicant.certificateCode}</td>
                </c>
                <c>
                    <td>${applicant.exam.firstExam.nameOfExam}</td>
                </c>
                <c>
                    <td>${applicant.exam.firstExam.result}</td>
                </c>
                <c>
                    <td>${applicant.exam.secondExam.nameOfExam}</td>
                </c>
                <c>
                    <td>${applicant.exam.secondExam.result}</td>
                </c>
                <c>
                    <td>${applicant.exam.thirdExam.nameOfExam}</td>
                </c>
                <c>
                    <td>${applicant.exam.thirdExam.result}</td>
                </c>
                <c>
                    <td>${applicant.speciality.university}</td>
                </c>
                <c>
                    <td>${applicant.speciality.faculty}</td>
                </c>
                <c>
                    <td>${applicant.speciality.speciality}</td>
                </c>
                <c>
                    <td>${applicant.averangeMarkOfTheCertificate}</td>
                </c>
                <c>
                    <td>${applicant.ruralCoef}</td>
                </c>
                <td><a href="/update?id=${applicant.id}"><img src="img/edit.png" alt="Edit" width="15" height="15"
                                                              title="Edit"></a></td>
                <td><a href="/delete?id=${applicant.id}"><img src="/img/delete.png" alt="Delete" width="15" height="15"
                                                              title="Delete"></a></td>
            </tr>
        </c:if>
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