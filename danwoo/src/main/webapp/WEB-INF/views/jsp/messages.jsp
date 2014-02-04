<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Chat History</title>

		<script src="<c:url value="/resources/lib/momentjs/2.5.1/moment-with-langs.min.js" />"></script>
	</head>
	<body>
		<script type="text/javascript">
			function appendMessage(message) {
				var time = moment(message.timestamp);
				var formattedTime = time.format("YYYY-MM-DD HH:mm:ss");
				
				if (message.ipAddress === null) {
					message.ipAddress = "N/A";
				}
				
				$("#messages").append(
						"<tr><td>" + formattedTime
						+ "</td><td>" + message.from
						+ "</td><td>" + message.ipAddress
						+ "</td><td>" + message.to
						+ "</td><td>" + message.value + "</td></tr>");
			}
			
			function getMessages() {
				$.getJSON("<c:url value="/messages.json" />", function (messages) {
					//console.log(messages);
					
					$.each(messages, function (i, message) {
						console.log(message);
						
						appendMessage(message);
					});
				});
			}
			
			$(function () {
				getMessages();
			});
		</script>
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 150px">Time</th>
					<th style="width: 150px">From</th>
					<th style="width: 150px">IP Address</th>
					<th style="width: 150px">To</th>
					<th>Message</th>
				</tr>
			</thead>
			<tbody id="messages">
			</tbody>
		</table>
	</body>
</html>
