<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.util.List" %>

<%@ page import="com.todo.list.model.Task" %>
<%@ page import="com.todo.list.service.TaskLocalServiceUtil" %>

<%@ page import="com.todo.list.model.SubTask" %>
<%@ page import="com.todo.list.service.SubTaskLocalServiceUtil" %>

<%@ page import="com.todo.list.model.TaskAttachment" %>
<%@ page import="com.todo.list.service.TaskAttachmentLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="java.util.List" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects/>