<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link rel="stylesheet" href="/css/codes.css">

</head>
<body>
<h1 id="title">Latest codes</h1>
<#list codes as code>
<span id="load_date">${code.getCreationDate()}</span>
<pre id="code_snippet"><code>${code.getCode()}</code></pre>
</#list>
</body>

</html>