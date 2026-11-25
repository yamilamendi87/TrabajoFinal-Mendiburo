# language: es
Característica: Flujo completo en OrangeHRM

  Escenario: Login exitoso
    Dado que el usuario está en la página de login de OrangeHRM
    Cuando ingresa el usuario "Admin" y la contraseña "admin123"
    Y hace clic en el botón de login
    Entonces debería visualizar el Dashboard

  Escenario: Buscar empleado
    Dado que el usuario ha iniciado sesión como "Admin" con contraseña "admin123"
    Cuando navega al módulo PIM
    Y busca el empleado "John Doe"
    Entonces debería ver resultados de la búsqueda

  Escenario: Buscar empleado y cerrar sesión
    Dado que el usuario ha iniciado sesión como "Admin" con contraseña "admin123"
    Cuando navega al módulo PIM y busca el empleado "John Doe"
    Y cierra sesión en la aplicación
    Entonces debería volver a la página de login