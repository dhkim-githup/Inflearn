<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko"  xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Coffee Menu</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" type="text/css" href="/css/comm.css">
  <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치 -->
<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>


<div id="main" style="font-size:large; text-align: center; ">

  <div id="search" style="height: 300px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
    <h3>[ Coffee menu 수정 <span style="font-size:30px;">&#9749;</span> ] <th:block th:text="${hello}"></th:block>  </h3>

    <form name="fm_menu_ins" autocomplete="on" action="/v2/menu_up" method="post">
      <fieldset>

        <legend> [커피 메뉴 등록] </legend>
        <label>메뉴명</label> <input type="text" id="name" name="coffee" value="${map.get("COFFEE")}"></p>
        <label>종 류 </label><select name="kind">
                            <option value="커피" ${map.get("KIND")=="커피" ? "selected" : ""}>커피</option>
                            <option value="논커피" ${map.get("KIND")=="논커피" ? "selected" : ""}>논커피</option>
                            <option value="에이드" ${map.get("KIND")=="에이드" ? "selected" : ""}>에이드</option>
                          </select>
                          </p>
        &nbsp;&nbsp;
        <label>가 격 </label><input type="number" name="price" value="${map.get('PRICE')}"></p>
        <input type="hidden" name="no" value="${map.get('NO')}">

        <input type="submit" value="메뉴 수정" style="width: 100px;height: 30px;font-weight: bold; font-size: medium">
      </fieldset>
    </form>


  </div>

</div>

<!--푸터위치-->
<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>

</body>
</html>


