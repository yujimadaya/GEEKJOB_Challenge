<%-- 
    Document   : hairetu
    Created on : 2018/06/17, 19:05:06
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<String> dates =new ArrayList<String>();

    dates.add("10");
    dates.add("100");
    dates.add("soeda");
    dates.add("hayashi");
    dates.add("-20");
    dates.add("118");
    dates.add("END");
    
    //1番目「10」を表示
    out.print(dates.get(0) + "<br>");
    //2番目「100」を表示
    out.print(dates.get(1) + "<br>");
    //3番目「soeda」を表示
    out.print(dates.get(2) + "<br>");
    //4番目「hayashi」を表示
    out.print(dates.get(3) + "<br>");
    //5番目「-20」を表示
    out.print(dates.get(4) + "<br>");
    //6番目「118」を表示
    out.print(dates.get(5) + "<br>");
    //7番目「END」を表示
    out.print(dates.get(6) + "<br>");
    
%>
