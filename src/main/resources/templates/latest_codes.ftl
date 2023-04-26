<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codes as code>
<span id="load_date">${code.getCreationDate()}</span>
<pre id="code_snippet">${code.getCode()}</pre>
<pre id="code_snippet">${code.getId()}</pre>
</#list>
</body>

</html>