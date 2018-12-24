<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add applicant</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<form action="/update" method="post">
			<fieldset>
				<p style="color: red;">${errorString}</p>
				<input type="hidden" name="id" value="${applicant.id}">
				<label for="firstName">First name:</label>
				<input type="text" name="firstName" value="${applicant.firstName}" pattern="^[A-Z][a-z -]+?$">
				<label for="lastName">Last name:</label>
				<input type="text" name="lastName"  value="${applicant.lastName}" pattern="^[A-Z][a-z -]+?$">
				<label for="surname">Surname:</label>
				<input type="text" name="surname"  value="${applicant.surname}" pattern="^[A-Z][a-z -]+?$">
				<label for="passportCode">Passport code:</label>
				<input type="text" name="passportCode"  value="${applicant.passportCode}" pattern="^[A-Z]{2}[0-9]{6}$">
				<label for="certificateCode">Certificate code:</label>
				<input type="text" name="certificateCode"  value="${applicant.certificateCode}" pattern="^[A-Z]{2}[0-9]{6}$">
										 
				<label for="firstExamName">Name of first exam:</label>
				<input type="text"  value="${applicant.exam.firstExam.nameOfExam}" name="firstExamName">
				<label for="firstExamResult">Mark of the first exam:</label>
				<input type="number"  value="${applicant.exam.firstExam.result}" name="firstExamResult" min="100" max="200" step="1">

				<label for="secondExamName">Name of the second exam:</label>
				<input type="text"  value="${applicant.exam.secondExam.nameOfExam}" name="secondExamName">
				<label for="secondExamResult">Mark of second exam:</label>
				<input type="number"  value="${applicant.exam.secondExam.result}" name="secondExamResult" min="100" max="200" step="1">
				
				<label for="thirdExamName">Name of the third exam:</label>
				<input type="text"  value="${applicant.exam.thirdExam.nameOfExam}" name="thirdExamName">
				<label for="thirdExamResult">Mark of second exam:</label>
				<input type="number"  value="${applicant.exam.thirdExam.result}" name="thirdExamResult" min="100" max="200" step="1">
				
				<label for="university">Name of the university: </label>
				<input type="text"  value="${applicant.speciality.university}" name="university">
				
				<label for="faculty">Name of the faculty: </label>
				<input type="text"  value="${applicant.speciality.faculty}" name="faculty">
				
				<label for="speciality">Name of the speciality: </label>
				<input type="text"  value="${applicant.speciality.speciality}" name="speciality">
				
				<label for="averageMarkOfTheCertificate">Average mark of the certificate: </label>
				<input type="number"  value="${applicant.averangeMarkOfTheCertificate}" min="2" max="12" step="0.1" name="averageMarkOfTheCertificate">
				
				<label for="ruralCoef">Rural coefficient: </label>

				<c:choose>
					<c:when test="${applicant.ruralCoef == true}">
						<input type="checkbox" checked name="ruralCoef">
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="ruralCoef" >
					</c:otherwise>
				</c:choose>

			</fieldset>
			<fieldset> 
				<a href="index.jsp"><button type="button">Back</button></a>
				<button type="reset" >Cancel</button>
    	    	<button type="submit">Submit</button>
			</fieldset>
      	</form>
    </body>
</html>