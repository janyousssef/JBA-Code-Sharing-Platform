<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
</head>
<body><span>date:</span>
<span id="load_date" th:utext="${code.creationDate}"></span>
<pre id="code_snippet" th:utext="${code.code}"></pre>
</body>

</html>