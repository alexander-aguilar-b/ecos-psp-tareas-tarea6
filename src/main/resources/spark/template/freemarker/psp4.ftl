<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

<div class="container">
  <h2>PSP4 - C&aacute;lculo de Tama&ntilde;o Relativo</h2>
  <h3>Datos de Entrada</h3>
  <h4>${etiquetaDatosEntrada}</h4>
    <ul>
    <#list entradas as x>
      <li> ${x} </li>
    </#list>
    </ul>
	<h3>Resultados</h3>
	<table border="1" style="border-collapse:collapse">
		<tr>
			<td><b>Very Small (VS)</b></td>
			<td><b>Small (S)</b></td>
			<td><b>Medium (M)</b></td>
			<td><b>Large (L)</b></td>
			<td><b>Very Large (VL)</b></td>
		</tr>
		<tr>
			<td>${tamanioVS}</td>
			<td>${tamanioS}</td>
			<td>${tamanioM}</td>
			<td>${tamanioL}</td>
			<td>${tamanioVL}</td>
		</tr>
</div>

</body>
</html>
