<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <script src="/scripts/script.js"></script>
    <link rel="stylesheet" href="/css/create.css">
</head>
<body>
<h1 id="title">Submit your code!</h1>
<form>
    Time Restriction: <input id="views_restriction" type="text">
    Views Restriction: <input id="time_restriction" type="text">
    <textarea id="code_snippet"> //write your code here </textarea>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
</body>
</html>