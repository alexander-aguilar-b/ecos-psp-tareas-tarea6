<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

<div class="container">
  <h2>PSP6 - C&aacute;lculo valor X</h2> 
  
  <hr>
  <br/>
  
  <table border="1" style="border-collapse:collapse">
		<tr>
			<td><b>p</b></td>
			<td><b>dof</b></td>
			<td><b>Valor Esperado x</b></td>
			<td><b>Valor Actual x</b></td>			
		</tr>
		<tr>
			<td>${valorPTest1}</td>
			<td>${valorDOFTest1}</td>
			<td>${valorXEsperadoTest1}</td>
			<td>${valorXCalculadoTest1}</td>			
		</tr>
		<tr>
			<td>${valorPTest2}</td>
			<td>${valorDOFTest2}</td>
			<td>${valorXEsperadoTest2}</td>
			<td>${valorXCalculadoTest2}</td>			
		</tr>
		<tr>
			<td>${valorPTest3}</td>
			<td>${valorDOFTest3}</td>
			<td>${valorXEsperadoTest3}</td>
			<td>${valorXCalculadoTest3}</td>			
		</tr>
	</table>	
</div>

</body>
</html>
