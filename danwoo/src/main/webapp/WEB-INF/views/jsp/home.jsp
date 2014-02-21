<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Chat with Bots</title>

		<script src="<c:url value="/resources/lib/momentjs/2.5.1/moment-with-langs.min.js" />"></script>
	</head>
	<body>
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
		
		<label for="to">Bot Type</label>
		<select id="to">
			<c:forEach var="botType" items="${botTypes}">
				<option value="${botType}">${botType}</option>
			</c:forEach>
		</select>
		<label for="username">Username</label>
		<input id="username" type="text">
		<label for="message">Message</label>
		<input id="message" type="text" autofocus="autofocus">
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
	</body>
</html>
