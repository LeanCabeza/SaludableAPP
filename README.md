# SaludableAPP
Aplicación para llevar control de las comidas de Pacientes 

<strong>Lo aplicado ... </strong><br>
  -MATERIAL DESIGN COMPONENTS <br>
	-DIALOGS<br>
	-CONSUMO DATOS DE UNA API Y LA MUESTRO EN MI APP <br>
	-SPLASH SCREEN<br>
	-FRAGMENTS<br>
	-UNIT TEST<br>
	-IMPLEMENTATION TEST<br>
	-FIREBASE : al usar firestore permite la persistencia de datos , por lo tanto se pueden loggear los usuarios tanto con internet , como sin internet
              Ademas , pueden agendar sus comidas y una vez que vuelvan a tener internet se sincronizaran
			        con la base de datos.<br>
	            En esta aplicacion , tuve la inclinacion de usar mucho las visibilidades "VISIBLE" Y "GONE" , para hacer aparecer y desaparecer partes de la app <br>
              <H2>Enunciado</h2>
              “Saludable” es una organización que se dedica a la realización de tratamientos<br>
              para personas con desordenes alimenticios.<br>
              Según el relevamiento realizado a Magali (Dueña de la organización) el<br>
              principal inconveniente para las especialistas es poder controlar diariamente a<br>
              sus pacientes.<br>
              Para entender la magnitud y complejidad de tratamientos, en la organización<br>
              trabajan psicólogos, médicos clínicos y nutricionistas. Actualmente la<br>
              organización cuenta con alrededor de 300 pacientes y 20 especialistas<br>
              trabajando de Lunes a Sabado.<br>
              “Saludable” posee una pagina web y un sistema para la asignación de turnos, pero<br>
              no posee ningún software para resolver el control diario de sus pacientes, por<br>
              lo cual los mismos deben completar un formulario a mano (diariamente)<br>
              especificando los datos solicitados por los especialistas.<br>
              Magali se contacto con nuestra empresa con el fin de solicitar una aplicación<br>
              móvil para que sus pacientes completen lo que comen diariamente (Desayuno,<br>
              almuerzo, merienda y cena), en un principio se lanzara solo la aplicación para<br>
              plataformas Android. Como se menciono anteriormente estos datos deben ser<br>
              visualizados en el sistema actual que posee “Saludable”, por lo cual deben ser<br>
              almacenados externamente.<br>
              Los pacientes se deben registrar desde la aplicación y deberán inciar sesión<br>
              para poder completar los datos diariamente.<br>
              Un paciente cuenta con los siguientes datos:
 Nombre<br>
 Apellido<br>
 DNI<br>
 Sexo<br>
 Fecha de nacimiento<br>
 Localidad<br>
 Usuario<br>
 Contraseña<br>
 Tipo de tratamiento<br>
o Anorexia<br>
o Bulimia<br>
o Obesidad<br>

El paciente deberá completar la siguiente información:<br>
 Tipo de comida diaria<br>
o Desayuno<br>
o Almuerzo<br>
o Merienda<br>
o Cena<br>
 Comida principal (es un campo de texto)<br>
 Comida secundaria (es un campo de texto)<br>
 Bebida<br>
 ¿Ingerio postre? (Solo se debe mostrar si eligio almuerzo o cena)<br>
o Si<br>
o No<br>
 Postre (Solo se debe mostrar si eligio “SI” en ingerio postre)<br>
 ¿Tenia tentación de ingerir otro alimento?<br>
o Si<br>
o No<br>
 Alimento que quería ingerir (Solo si elegio “SI” en el punto anterior)<br>
 ¿Se quedo con hambre?<br>
o Si<br>
o No<br>

Además de estos datos el sistema deberá almacenar fecha y hora en que el<br>
paciente ingreso los datos.<br>
Cuando el paciente termine de completar estos datos presionara en el boton<br>
guardar y se alamacenaran los mismos.<br>
Como premio de haber utilizado la aplicación la misma tiene que ofrecer un<br>
trago y mostrar las características incluida su imagen<br>
API<br>
https://www.thecocktaildb.com/api/json/v1/1/random.php<br>
Nota: El paciente podría completar los datos aun estando offline, en este caso la<br>
aplicación deberá funcionar igual y sincronizar los datos cuando vuelva a estar<br>
online.<br>
