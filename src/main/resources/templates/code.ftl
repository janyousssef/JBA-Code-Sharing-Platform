<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link rel="stylesheet" href="/css/codes.css">
</head>
<h1>Code</h1>
<#if code.isTimeLimited()>
<span id="time_restriction">Time remaining: ${code.getRemainingTimeSecs()} </span>
<br>
</#if>
<#if code.isViewsLimited()>
<span id="views_restriction">Views remaining: ${code.getViews()} </span>
<br>
</#if>
<span id="load_date">${code.getCreationDate()}</span>
<pre id="code_snippet"><code>${code.getCode()}</code></pre>


</body>

</html>