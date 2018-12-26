<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>All applicants</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form>
    <legend>All applicants</legend>
    <p style="color: red;">${errorString}</p>
    <fieldset>
        <table border align="center">
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
                <th>Rural coef</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach items="${applicantsList}" var="applicant">
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
                    <td><a href="/update?id=${applicant.id}"><img src="img/edit.png" alt="Edit" width="15"
                                                                  height="15" title="Edit"></a></td>
                    <td><a href="/delete?id=${applicant.id}"><img src="/img/delete.png" alt="Delete" width="15"
                                                                  height="15" title="Delete"></a></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    <a href="index.jsp">
        <button type="button">Back</button>
    </a>
</form>
</body>
</html>