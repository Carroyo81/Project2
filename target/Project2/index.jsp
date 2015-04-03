<html>
    <body>
        <h2>Favorite Websites</h2>
        <p><a href="webapi/myresource/AllSites ">All Websites</a>

        <FORM action="http://localhost:8084/Project2/webapi/myresource/urlInput" method="post">
            <p>To enter a website fill form below</p>
            <P>           
                Favorite Website : <INPUT type="text" name="url"><BR>
                Category: <input type="text" name="category"><br>
                <INPUT type="submit" value="Send">
            </P>
        </FORM>
         <form action="http://localhost:8084/Project2/webapi/myresource/cat" method="get">
            <p>
                To search websites by category
            </p>
            <p>
                Enter Category <input type="text" name="category"><br>
                <input type="submit" value="send">
            </p>
        </form>
    </body>
</html>
