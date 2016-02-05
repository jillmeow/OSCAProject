<%-- 
    Document   : Checkout
    Created on : 18/09/2014, 9:03:52 PM
    Author     : Kendall Lauren Chin
--%>


<%@page import="domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="domain.Order"%>
<%@page import="domain.OrderItem"%>
<%@page import="domain.OrderItem"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function confirmCancel(){
                if(confirm("Are you sure you want to cancel your order?")){
                    window.location="/shopping/RemoveOrderServlet";
                } else{
                    return false;
                }
                return true;
            }
            function confirmRemoveItem(){
                if(confirm("Are you sure you want to remove this from your order?")){
                    window.location="/shopping/RemoveFromOrderServlet";
                } else{
                    return false;
                }
                return true;
            }
        </script>
        <title>Checkout</title>
    </head>
    <body>

        <h1>Shopping Cart</h1>             

        <%            Double orderTotal = 0.0;
            Order order = (Order) session.getAttribute("order");

            List<OrderItem> orderItems = order.getItems();
            if (orderItems.isEmpty()) {
        %>
        <h2 align="center">Your shopping cart is empty!</h2>
        <div id="form" align="center">
            <a href="/shopping/restricted/ViewProducts.jsp">Click here to continue shopping!</a>

        </div>
        <%
        } else {
        %>
        <h2 align="center">Your order currently consists of:</h2>
        <div id="form">
            <fieldset>
                <table id="t" border="1">
                    <thead>
                        <tr>
                            <th>Product Id</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th> </th>
                        </tr>
                    </thead>


                    <%
                        for (OrderItem orderItem : orderItems) {
                            Product product = orderItem.getaProduct();
                            Integer quantity = orderItem.getQuantityPurchased();
                            Double price = product.getPrice();
                            String productName = product.getName();
                            Integer productId = product.getId();
                            Double total = orderItem.getItemTotal();
                            orderTotal += total;
                    %>
                    <tbody>                              
                        <tr>
                            <td><%=productId%></td>
                            <td><%=productName%></td>
                            <td><%="$" + price%></td>
                            <td><%=quantity%></td>
                            <td><%="$" + total%></td>
                    
                            <td><button type="submit" onclick="confirmRemoveItem()()"name="orderId" value="<%=product.getId()%>">Remove</button></td>
                                        </tr>
                    <%}
                    %>
                    </tbody>
                </table>
                <br>Total cost of order: <%="$" + orderTotal%>
                <form action="/shopping/ConfirmOrderServlet" method="post">    
                    <button type="submit">Confirm Order</button> 
                </form>
                
                <button type="submit" onclick="confirmCancel()()">Cancel Order</button>
                                 
                <a href="/shopping/restricted/ViewProducts.jsp">Click here to continue shopping!</a>
            </fieldset>
        </div> 
        <%
            }%>
    </body>
</html>
