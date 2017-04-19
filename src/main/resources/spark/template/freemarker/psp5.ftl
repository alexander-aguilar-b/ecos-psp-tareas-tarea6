<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

<div class="container">
  <h2>PSP5 - C&aacute;lculo de Integral</h2>
  <h3>${ numeroTest }</h3>
  
  <hr>
  <br/>
  
  <table border="1" style="border-collapse:collapse">
		<tr>
			<td><b>X</b></td>
			<td><b>DOF</b></td>
			<td><b>Valor Esperado</b></td>
			<td><b>Valor Actual</b></td>			
		</tr>
		<tr>
			<td>${valorX}</td>
			<td>${gradosLibertad}</td>
			<td>${valorEsperado}</td>
			<td>${valorActual}</td>			
		</tr>
	</table>	
</div>

</body>
</html>
