<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Applicant</title>
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body link="#8B8B8B" alink="#FF474A" vlink="#8B8B8B">

<form action="get">
  <legend>Applicants</legend>
  <ul>
    <a href="/list">
      <li>Print all applicants</li>
    </a>
    <br>
    <a href="addApplicant.jsp">
      <li>Add applicant</li>
    </a>
    <br>
    <a href="findByName.jsp">
      <li>Find applicant by name</li>
    </a>
    <br>
    <a href="findByID.jsp">
      <li>Find applicant by id</li>
    </a>
    <br>
    <a href="excelentApplicants.jsp">
      <li>Find excelent applicants</li>
    </a><br>
    <a href="/ruralCoef">
      <li>Find applicants with rural coefficient</li>
    </a>
    <br>
    <a href="findByEnteredNameAndResult.jsp">
      <li>Find applicants who passed entered exam grater than given mark</li>
    </a>
    <br>
  </ul>
</form>
</body>
</html>