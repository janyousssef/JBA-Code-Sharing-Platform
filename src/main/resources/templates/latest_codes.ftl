<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codes as code>
<span id="load_date">${code.creationDate()}</span>
<pre id="code_snippet">${code.code()}</pre>
</#list>
</body>

</html>