package API;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author Mario Rios <jose.rf@culiacan.tecnm.mx>
 * Se tomo como base el codigo de esta pagina: https://www.baeldung.com/java-http-request
 */
public class ApiHelper {
    private HttpURLConnection conexion;
    
    private void imprimeError(Exception ex){
        System.out.println(ApiHelper.class.getName() + " | " + ex.getClass()  + " | " + ex.getMessage());
    }
    
    public String get(String endpointUrl){
        
        StringBuilder datos = null;
        try {
            URL url = new URL(endpointUrl);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
        } catch (MalformedURLException ex) {
            imprimeError(ex);
        } catch (ProtocolException ex) {
            imprimeError(ex);
        } catch (IOException ex) {
            imprimeError(ex);
        }
        
        try {
            int status = conexion.getResponseCode();
            if(status == 200){
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));
                  String inputLine;
                  datos = new StringBuilder();
                  while ((inputLine = in.readLine()) != null) {
                      datos.append(inputLine);
                  }
                  in.close();
            }
        } catch (IOException ex) {
            imprimeError(ex);
        }
        
        return datos.toString();
    }
}
