# Explicacion Edlin

- El edlin que se entregó en el pull request era malo, ya que no cumplia con los requisitos de clase, sin ningun UML ni readme, el commit anterior a este, servía para refactorizar el código (que por cierto no tiene commits, debido a que lo hice primero en otra carpeta y luego solo copie y pegue, pido una _DISCULPA_), sin embargo, este modelo de edlin, ya se encuentra de mejor manera, y lo hice para que luego se pueda usar el `IO` de manera adecuada

- Para poder realizar luego el `IO` me guié en el archivo proporcionado por el catedrático (así que si se ven particularmente similares, es por esa razón)

- Se crearon 2 opciones para salir
  - La primera es la opción S, la cual sale del programa (Edlin) pero el archivo `.txt` se conserva, se guarda
  - La segunda es la opción X, la cual borra el .txt, y esto hace que todo el programa se rompa, por más que se quiera realizar otra opción, por ende, se deberá salir del programa (usando la opción de S) obligatoriamente.

### 🚨 IMPORTANTE

No se que tan importante o no pueda hacer esto, pero me surge la duda, al momento en el que se sale con `s` del programa el archivo .txt se queda guardado, y al iniciar el programa, se usa ese archivo, por ende, se usa con las modificaciones anteriores, ¿esto es bueno o malo? ¿debería de crearse otro archivo .txt o usar ese mismo?
