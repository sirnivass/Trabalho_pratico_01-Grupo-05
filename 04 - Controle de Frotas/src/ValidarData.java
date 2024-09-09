import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidarData {
    public static boolean validarData(String dataString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Isso força a análise estrita da data
        try {
            Date data = sdf.parse(dataString); // Tenta converter a String para uma Data
            return true; // A data é válida
        } catch (ParseException e) {
            return false; // A data é inválida
        }
    }
}
