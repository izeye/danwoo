<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Chat with Bots</title>

		<script src="<c:url value="/resources/lib/momentjs/2.5.1/moment-with-langs.min.js" />"></script>
	</head>
	<body>
		<label for="to">Bot Type</label>
		<select id="to" onchange="drawBot()">
			<c:forEach var="botType" items="${botTypes}">
				<option value="${botType}">${botType}</option>
			</c:forEach>
		</select><br/>
		
		<canvas id="bot" width="100" height="100"></canvas><br/>
		
		<label for="username">Username</label>
		<input id="username" type="text"><br/>
		<label for="message">Message</label>
		<input id="message" type="text" autofocus="autofocus" lang="en" x-webkit-speech>
		<input type="button" value="Send" onclick="sendRequest();">
		
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 150px">Time</th>
					<th style="width: 150px">ID</th>
					<th>Message</th>
				</tr>
			</thead>
			<tbody id="messages">
			</tbody>
		</table>
		
		<script type="text/javascript">
			var canvas = document.getElementById("bot");
			var context = canvas.getContext("2d");
			
			var FACE_RADIUS = 45;
			
			var ALICE_FACE_COLOR = "pink";
			var DANWOO_FACE_COLOR = "yellow";
			var ELIZA_FACE_COLOR = "gray";
			
			var FACE_COLORS = {};
			FACE_COLORS['ALICE'] = ALICE_FACE_COLOR;
			FACE_COLORS['DANWOO'] = DANWOO_FACE_COLOR;
			FACE_COLORS['ELIZA'] = ELIZA_FACE_COLOR;
			
			function degree2Radian(degree) {
				return degree / 180 * Math.PI;
			}
			
			function drawFace(faceColor) {
				var x = canvas.width / 2;
				var y = canvas.height / 2;
				var radius = FACE_RADIUS;
				
				context.beginPath();
				context.arc(x, y, radius, 0, degree2Radian(360));
				context.stroke();
				context.fillStyle = faceColor;
				context.fill();
			}
			
			function drawMouth() {
				var x = canvas.width / 2;
				var y = canvas.height / 2;
				var radius = FACE_RADIUS * (3/4);
				
				context.beginPath();
				context.arc(x, y, radius, degree2Radian(0), degree2Radian(180));
				context.stroke();
			}
			
			function drawEye(x, y) {
				var radius = FACE_RADIUS / 6;
				
				context.beginPath();
				context.arc(x, y, radius, degree2Radian(0), degree2Radian(360));
				context.stroke();
				context.fillStyle = "black";
				context.fill();
			}
			
			function drawEyes() {
				var x = canvas.width / 3;
				var y = canvas.height / 3;
				drawEye(x, y);
				
				x = canvas.width * (2/3);
				drawEye(x, y);
			}
			
			function drawBot() {
				var bot = $('#to').val();
				var faceColor = FACE_COLORS[bot];
				
				drawFace(faceColor);
				drawMouth();
				drawEyes();
			}
			
			drawBot();
		</script>
		
		<script type="text/javascript">
			function prependMessage(timestamp, who, message) {
				var time = moment(timestamp);
				var formattedTime = time.format("YYYY-MM-DD HH:mm:ss");
				
				$("#messages").prepend(
						"<tr><td>" + formattedTime
						+ "</td><td>" + who
						+ "</td><td>" + message + "</td></tr>");
			}
			
			function sendRequest() {
				var timestamp = new Date().getTime();
				var from = $("#username").val();
				if (from === '') {
					alert("Username can't be empty!");
					return;
				}
				var to = $("#to").val();
				var message = $("#message").val();
				if (message === '') {
					alert("Message can't be empty!");
					return;
				}
				$("#message").val('');
				
				prependMessage(timestamp, from, message);
				
				$.getJSON("<c:url value="/respond" />", {
					timestamp: timestamp,
					from: from,
					to: to,
					value: message
				}, function (data) {
					console.log(data);

					prependMessage(data.timestamp, data.from, data.value);
				});
			}
			
			$(function () {
				$("#message").keydown(function (e) {
					if (e.keyCode === 13) {
						sendRequest();
					}
				});
			});
		</script>
	</body>
</html>
