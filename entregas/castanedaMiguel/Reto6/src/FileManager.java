import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String filePath;
    private static final int MAX_LINES = 1000;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public boolean createFile(String content) {
        File archivo = new File(this.filePath);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

            boolean var4;
            try {
                writer.write(content);
                var4 = true;
            } catch (Throwable var7) {
                try {
                    writer.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            writer.close();
            return var4;
        } catch (IOException var8) {
            System.err.println("Error al crear/escribir el archivo: " + var8.getMessage());
            return false;
        }
    }

    public String readFile() {
        File archivo = new File(this.filePath);
        StringBuilder contenido = new StringBuilder();
        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return null;
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(archivo));

                String var5;
                try {
                    String linea;
                    while((linea = reader.readLine()) != null) {
                        contenido.append(linea);
                        contenido.append(System.lineSeparator());
                    }

                    var5 = contenido.toString();
                } catch (Throwable var7) {
                    try {
                        reader.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }

                    throw var7;
                }

                reader.close();
                return var5;
            } catch (IOException var8) {
                System.err.println("Error al leer el archivo: " + var8.getMessage());
                return null;
            }
        }
    }

    private int countLines() {
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));

            try {
                while(reader.readLine() != null) {
                    ++count;
                }
            } catch (Throwable var6) {
                try {
                    reader.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            reader.close();
        } catch (IOException var7) {
            System.err.println("Error al contar líneas: " + var7.getMessage());
        }

        return count;
    }

    public boolean updateLine(int lineNumber, String newLine) {
        int totalLines = this.countLines();
        if (lineNumber >= 1 && lineNumber <= totalLines) {
            String[] lines = new String[totalLines];

            int i;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.filePath));

                try {
                    for(i = 0; i < totalLines; ++i) {
                        lines[i] = reader.readLine();
                    }
                } catch (Throwable var12) {
                    try {
                        reader.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }

                    throw var12;
                }

                reader.close();
            } catch (IOException var13) {
                System.err.println("Error al leer el archivo: " + var13.getMessage());
                return false;
            }

            lines[lineNumber - 1] = newLine;

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));

                boolean var15;
                try {
                    i = 0;

                    while(true) {
                        if (i >= lines.length) {
                            var15 = true;
                            break;
                        }

                        writer.write(lines[i]);
                        if (i < lines.length - 1) {
                            writer.newLine();
                        }

                        ++i;
                    }
                } catch (Throwable var10) {
                    try {
                        writer.close();
                    } catch (Throwable var8) {
                        var10.addSuppressed(var8);
                    }

                    throw var10;
                }

                writer.close();
                return var15;
            } catch (IOException var11) {
                System.err.println("Error al escribir el archivo: " + var11.getMessage());
                return false;
            }
        } else {
            System.err.println("Número de línea fuera de rango");
            return false;
        }
    }

    public boolean deleteFile() {
        File archivo = new File(this.filePath);
        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return false;
        } else {
            return archivo.delete();
        }
    }

    public boolean deleteLine(int lineNumber) {
        int totalLines = this.countLines();
        if (lineNumber >= 1 && lineNumber <= totalLines) {
            String[] lines = new String[totalLines];

            int i;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.filePath));

                try {
                    for(i = 0; i < totalLines; ++i) {
                        lines[i] = reader.readLine();
                    }
                } catch (Throwable var11) {
                    try {
                        reader.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }

                    throw var11;
                }

                reader.close();
            } catch (IOException var12) {
                System.err.println("Error al leer el archivo: " + var12.getMessage());
                return false;
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));

                boolean var14;
                try {
                    i = 0;

                    while(true) {
                        if (i >= lines.length) {
                            var14 = true;
                            break;
                        }

                        if (i + 1 != lineNumber) {
                            writer.write(lines[i]);
                            if (i < lines.length - 1) {
                                writer.newLine();
                            }
                        }

                        ++i;
                    }
                } catch (Throwable var9) {
                    try {
                        writer.close();
                    } catch (Throwable var7) {
                        var9.addSuppressed(var7);
                    }

                    throw var9;
                }

                writer.close();
                return var14;
            } catch (IOException var10) {
                System.err.println("Error al escribir el archivo: " + var10.getMessage());
                return false;
            }
        } else {
            System.err.println("Número de línea fuera de rango");
            return false;
        }
    }
}

