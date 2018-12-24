<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add applicant</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<form action="/add" method="get">
			<fieldset>
				<p style="color: red;">${errorString}</p>
				<label for="firstName">First name:</label>
				<input type="text" name="firstName" pattern="^[A-Z][a-z -]+?$">
				<label for="lastName">Last name:</label>
				<input type="text" name="lastName" pattern="^[A-Z][a-z -]+?$">
				<label for="surname">Surname:</label>
				<input type="text" name="surname" pattern="^[A-Z][a-z -]+?$">
				<label for="passportCode">Passport code:</label>
				<input type="text" name="passportCode" pattern="^[A-Z]{2}[0-9]{6}$">
				<label for="certificateCode">Certificate code:</label>
				<input type="text" name="certificateCode" pattern="^[A-Z]{2}[0-9]{6}$">
										 
				<label for="firstExamName">Name of first exam:</label>
				<input type="text" name="firstExamName">
				<label for="firstExamResult">Mark of the first exam:</label>
				<input type="number" name="firstExamResult" min="100" max="200" step="1">

				<label for="secondExamName">Name of the second exam:</label>
				<input type="text" name="secondExamName">
				<label for="secondExamResult">Mark of second exam:</label>
				<input type="number" name="secondExamResult" min="100" max="200" step="1">
				
				<label for="thirdExamName">Name of the third exam:</label>
				<input type="text" name="thirdExamName">
				<label for="thirdExamResult">Mark of second exam:</label>
				<input type="number" name="thirdExamResult" min="100" max="200" step="1">
				
				<label for="university">Name of the university: </label>
				<input type="text" name="university">
				
				<label for="faculty">Name of the faculty: </label>
				<input type="text" name="faculty">
				
				<label for="speciality">Name of the speciality: </label>
				<input type="text" name="speciality">
				
				<label for="averageMarkOfTheCertificate">Average mark of the certificate: </label>
				<input type="number" min="2" max="12" step="0.1" name="averageMarkOfTheCertificate">
				
				<label for="ruralCoef">Rural coefficient: </label>
				<input type="checkbox" name="ruralCoef">
			</fieldset>
			<fieldset> 
				<a href="index.jsp"><button type="button">Back</button></a>
				<button type="reset" >Cancel</button>
    	    	<button type="submit">Submit</button>
			</fieldset>
      	</form>
    </body>
</html>