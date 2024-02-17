<table id="courses table">
    <c:forEach items="${data}" var="dataPunkt">
        <tr>
            <td>${dataPunkt[0]}</td>
            <td>${dataPunkt[1]}</td>
            <td>${dataPunkt[2]}</td>
            <td>${dataPunkt[3]}</td>
        </tr>
    </c:forEach>
</table>