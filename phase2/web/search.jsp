<!DOCTYPE html>

<%@page import="java.util.Collection"%>
<%@page import="domain.Member"%>
<%@page import="dao.MemberJdbcDAO"%>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Otago Southland Chinese Association">
        <meta name="author" content="INFO312 Students">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="favicon.ico">
        <link rel="stylesheet" href="style.css">
        <script src="jquery-1.11.1.min.js"></script>
        <title>OSCA: Otago Chinese Association</title>
    </head>
    <body>
        <section>
            <header>
                <div id="logo">
                    <img src="logo.jpg" alt="The New Zealand Chinese Association, Otago and Southland Branch Logo">
                </div>

                <nav id="menu">
                    <ul>
                        <li class="links">
                            <a href="index.html">
                                Home
                            </a>
                        </li>
                        <li class="links">
                            <a href="membership.html">
                                Membership
                            </a>
                        </li>
                        <li class="links">
                            <a>
                                Search
                            </a>
                        </li>
                    </ul>
                </nav>
            </header>       
        </section>
        <section>
            <form action="/info221-phase2/SearchServlet" method="post">
                <div id="searchBar">     
                    <h1>Search</h1>
                    <%
                        Collection<Member> members = new MemberJdbcDAO().getAll();
                        MemberJdbcDAO dao = new MemberJdbcDAO();
                    %>



                    <label id="search">Search: <input type="text" name="searchKeyWords"></label>
                    <button id="searchButton" type="button">Search</button>
                    <button id="clearButton" type="button">Clear</button>
                </div>
                <div id="viewMembers">
                    <div class="viewFN">
                        <h3>First Name</h3>
                    </div>
                    <div class="viewLN">
                        <h3>Last Name</h3>
                    </div>
                    <div class="viewA">
                        <h3>Address</h3>
                    </div>
                    <div class="viewPN">
                        <h3>Phone Number</h3>
                    </div>
                    <div class="viewE">
                        <h3>Email</h3>
                    </div>
                    <div class="viewAct">
                        <h3>Activities</h3>
                    </div>
                    <div class="viewPart">
                        <h3>Partner</h3>
                    </div>
                    <div class="viewSib">
                        <h3>Siblings</h3>
                    </div>
                    <div class="viewChild">
                        <h3>Children</h3>
                    </div>
                    <%
                        for (Member member : members) {
                            
                    %>

                    <div class="viewFN"><%=member.getFirstName()%></div>
                    <div class="viewLN"><%=member.getLastName()%></div>
                    <div class="viewA"><%=member.getAddress()%></div>
                    <div class="viewPN"><%=member.getPhoneNumber()%></div>
                    <div class="viewE"><%=member.getEmail()%></div>
                    <div class="viewAct"><%=member.getCatagories()%></div>
                    <div class="viewPart"><%=member.getPartnersName()%></div>
                    <div class="viewSib"><%=member.getSiblingsName()%></div>
                    <div class="viewChild"><%=member.getChildren()%></div>

                    <%
                            }%>


                </div>
            </form>

        </section>
    </body>
</html>