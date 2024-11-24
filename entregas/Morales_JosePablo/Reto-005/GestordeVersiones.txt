@startuml
class Archivo {
  +nombre: String
  +contenido: String
  +fechaCreacion: Date
  +fechaModificacion: Date
  +obtenerHistorial(): List<VersionArchivo>
}

class Directorio {
  +nombre: String
  +archivos: List<Archivo>
  +subdirectorios: List<Directorio>
  +agregarArchivo(archivo: Archivo): void
  +eliminarArchivo(nombre: String): void
  +obtenerArchivo(nombre: String): Archivo
}

class VersionArchivo {
  +contenido: String
  +fecha: Date
}

class Commit {
  +mensaje: String
  +fecha: Date
  +archivosGuardados: Map<String, VersionArchivo>
  +mostrarArchivos(): void
}

class Rama {
  +nombre: String
  +commits: List<Commit>
  +crearCommit(mensaje: String, directorio: Directorio): Commit
  +cambiarCommit(commit: Commit): void
}

class ControlVersiones {
  +ramaActual: Rama
  +ramas: List<Rama>
  +crearRama(nombre: String): Rama
  +cambiarRama(nombre: String): void
  +obtenerHistorialVersiones(): List<Commit>
}

Archivo "1" -- "*" VersionArchivo : guarda
Directorio "1" *-- "*" Archivo : contiene
Directorio "1" *-- "*" Directorio : subdirectorio
Commit "1" *-- "*" VersionArchivo : incluye
Rama "1" *-- "*" Commit : contiene
ControlVersiones "1" *-- "*" Rama : maneja
ControlVersiones "1" -- "1" Rama : rama actual

@enduml
