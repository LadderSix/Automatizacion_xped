package xped.automation.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    //Atributos
    private static Properties props;

    public static String getProperty(String key){
        //Instanciamos un objero properties
        props = new Properties();
        // Definimos String con la ruta del fichero con las properties del proyecto
        String rutaFile = "C:\\IdeaProjects\\Automatización_xped\\src\\test\\resources\\data.properties";

        //Intentamos instancia el fichero como un objeto de tipo file
        try {
            InputStream input = new FileInputStream(rutaFile);
            //Cargamos las properties del fichero
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Retornamos una property en base a su key
        return props.getProperty(key);
    }
}
