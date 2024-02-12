# APP PARKING

<div align="center">
  <h2>Javier Sánchez González</h2>
  <img src="src/main/resources/png/LogoParking.png" alt="Logo Parking" width="200"/>
  <img src="src/main/resources/png/LogoCar.png" alt="Logo Car" width="200"/>
</div>

## Estructura del Proyecto

El proyecto se organiza en tres paquetes principales: `controlador`, `modelo` y `vista`.

### Paquete controlador
Contiene las clases que manejan la lógica de la aplicación y la conexión con la base de datos.
- `EmailUtil.java`: Utilidad para enviar correos electrónicos.
- `HibernateUtil.java`: Configuración de Hibernate.
- `Load.java`: Clase para cargar recursos.
- `MetodosBarra.java`: Métodos relacionados con la barra de navegación.
- `MetodosContrasena.java`: Métodos para la gestión de contraseñas.
- `MetodosCuenta.java`: Métodos para la gestión de cuentas de usuario.
- `MetodosHistorial.java`: Métodos para el manejo del historial de reservas.
- `MetodosInicio.java`: Métodos para la pantalla de inicio.
- `MetodosRecuperarContrasena.java`: Métodos para recuperar contraseñas olvidadas.
- `MetodosRegistroCuenta.java`: Métodos para el registro de cuentas nuevas.
- `MetodosReservar.java`: Métodos para la gestión de reservas de parking.

### Paquete modelo
Contiene las clases que representan las entidades de la aplicación.
- `Historial.java`: Entidad para el historial de reservas.
- `Reservas.java`: Entidad para las reservas.
- `Usuarios.java`: Entidad para los usuarios.
- `Vehiculos.java`: Entidad para los vehículos.

### Paquete vista
Contiene las clases que manejan la interfaz de usuario.
- `Cuenta.java`: Pantalla de gestión de cuenta de usuario.
- `Historiales.java`: Pantalla del historial de reservas.
- `InicioCuenta.java`: Pantalla de inicio de sesión y creación de cuenta.
- `InicioSesion.java`: Pantalla de inicio de sesión.
- `Loading.java`: Pantalla de carga.
- `PanelRound.java`: Panel con bordes redondeados.
- `Parking.java`: Pantalla principal de la aplicación de parking.
- `RecuperarContrasena.java`: Pantalla para recuperar la contraseña.
- `RegistroCuenta.java`: Pantalla para registrar una nueva cuenta.
- `Reserva.java`: Pantalla para realizar una reserva.



