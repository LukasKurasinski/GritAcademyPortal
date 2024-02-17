<navbar id="studentNavbar">
    <nav>
        <ul>
            <li>
                <form action="/userPage" method="post">
                <select id="user_type" name="courseName">
                    <c:forEach items="${data}" var="dataPunkt">
                        <option value="${dataPunkt[1]}">${dataPunkt[1]}</option>
                    </c:forEach>
                </select>
                <input type="submit" id="studentSubmit" name="studentSubmit" value="show details">
                </form>
            </li>
        </ul>
    </nav>
</navbar>