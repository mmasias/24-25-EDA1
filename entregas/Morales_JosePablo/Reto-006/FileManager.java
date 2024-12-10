import java.io.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private String dominio = "mi-dominio";

    public void guardar(ControlVersiones controlVersiones, String filePath) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> data = new HashMap<>();
        data.put("dominio", dominio);
        data.put("controlVersiones", controlVersiones);
        String json = gson.toJson(data);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        }
    }

    public ControlVersiones leer(String filePath) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Object> data = gson.fromJson(reader, new TypeToken<Map<String, Object>>(){}.getType());
            String dominioLeido = (String) data.get("dominio");
            if (!dominioLeido.equals(dominio)) {
                throw new SecurityException("Dominio no coincidente.");
            }
            return gson.fromJson(gson.toJson(data.get("controlVersiones")), ControlVersiones.class);
        }
    }
}
