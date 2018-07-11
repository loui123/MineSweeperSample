<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="resources/minesweeper.js"></script>
<script src="resources/vendor/jquery-3.3.1.min.js"></script>
<html>
<head>
	<title>MineSweeper</title>
</head>
<body>
<h1>
	Welcome to MineSweeper!  
</h1>

<button type="submit" onclick="getMapData()">Initialize</button>
<div id="mine_sweeper"></div>

</body>
</html>