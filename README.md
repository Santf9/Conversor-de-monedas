# <h1 style="text-align:center;">Challenge Conversor de Monedas 💱</h1>

# 📝 Descripción
Este proyecto forma parte de la Formación Backend de Alura Latam. Consiste en crear una aplicación de consola en Java que permite convertir valores entre distintas monedas extrayendo Tasas de Cambio Actuales
desde una API.

# 🛠️ Tecnologías utilizadas

- **Java 21**
- **IDE recomendado**: IntelliJ IDEA o Visual Studio Code
- **Entrada por consola** (`Scanner`)
- **ExchangeRate-API**: Brinda la actualización de Tasas de Conversión de Monedas de 161 países.

# 📁 Estructura del proyecto

```
Conversor-de-monedas/
├── src/
   ├── main/
   │  └── Main.java
   ├── modelos/
   │  └── ConvertirMoneda.java
   │  └── Monedas.java
   ├── services/
      └── ConsultaMoneda.java
```

# 🚀 ¿Cómo ejecutar?

1. Clona este repositorio:

```bash
git clone https://github.com/Santf9/Conversor-de-monedas.git
cd Conversor-de-monedas
```
2. Compila el proyecto:

```bash
javac src/*.java
```

3. Ejecuta el programa:

```bash
java src.Main
```

> Asegúrate de tener Java correctamente configurado en tu sistema.

# ✨ Funcionalidades

- Conversión entre:
    - $USD ↔ $ARS
    - $ARS ↔ $USD
    - $USD ↔ $BRL
    - $BRL ↔ $USD
    - $USD ↔ $COP
    - $COP ↔ $USD
- Entrada personalizada para conversión de otras monedas
- Muestra la tasa de conversión actual
- Interfaz interactiva por consola