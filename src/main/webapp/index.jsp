<%--
  Created by IntelliJ IDEA.
  User: kernel32
  Date: 29.03.2018
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./custom.css">
    <script src="./script.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>RESTful OLX WebService</title>
</head>
<body>
<div class="addFormBlock">
    <b>Add key (POST method)</b>
    <form action="./rest/key/add" method="POST">
        <div class="form-group">
            <input type="text" class="form-control" name="key" placeholder="Enter keyword">
        </div>
        <div class="form-group">
            <label>Date from</label>
            <input type="date" class="form-control" name="from" >
        </div>
        <div class="form-group">
            <label>Date to</label>
            <input type="date" class="form-control" name="to" >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<div class="updateFormBlock">
    <b>Update key (PUT method)</b>
    <form action="./rest/key/update" method="PUT">
        <div class="form-group">
            <input type="text" class="form-control" name="key" placeholder="Enter keyword">
        </div>
        <div class="form-group">
            <label>Date from</label>
            <input type="date" class="form-control" name="from" >
        </div>
        <div class="form-group">
            <label>Date to</label>
            <input type="date" class="form-control" name="to" >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<div class="getFormBlock">
    <b>Get key (GET method)</b>
    <form id="getKeyForm" onsubmit="getKeyValue()" method="GET">
        <div class="form-group">
            <input type="text" class="form-control" name="keyValue" placeholder="Enter keyword">
        </div>
        <button type="submit" class="btn btn-primary" id="leftGetButton">Submit</button>
    </form>
</div>
<div class="deleteFormBlock">
    <b>Delete key (DELETE method)</b>
    <form id="deleteKeyForm" onsubmit="deleteKeyValue()" method="DELETE">
        <div class="form-group">
            <input type="text" class="form-control" name="keyValue" placeholder="Enter keyword">
        </div>
        <button type="submit" class="btn btn-primary" id="leftDeleteButton">Submit</button>
    </form>
</div>
<div class="listFormBlock">
    <form action="./rest/key/list" method="GET">
        <button type="submit" class="btn btn-primary" id="leftListButton">List all keywords</button>
    </form>
</div>
</body>
</html>
