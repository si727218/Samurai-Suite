# Samurai-Suite
# Dependencias
- Agregar JAR de commons codec al proyecto

Para la tipografía se deben modificar los Paths en la clase GUI

~~~java
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/proyecto/IBM-Logo.ttf")).deriveFont(30f); //NOTA el path de la tipografía se debe modificar
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/proyecto/IBM-Logo.ttf"))); //NOTA el path de la tipografía se debe modificar
~~~

```
src/proyecto/IBM-Logo.ttf"))
```

https://github.com/si727218/Samurai-Suite
