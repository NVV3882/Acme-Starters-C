
<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list>
	<acme:list-column code="authenticated.strategy.list.label.name" path="name"/>
	<acme:list-column code="authenticated.strategy.list.label.description" path="description"/>
</acme:list>
