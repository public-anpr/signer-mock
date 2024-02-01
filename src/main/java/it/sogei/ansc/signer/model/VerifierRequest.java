package  it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Richiesta per la verifica di un p7m o per la sua composizione" )
public class VerifierRequest {

	@Schema( description = "L'oggetto di cui verificare la firma cdoficato base64", 
			type = SchemaType.STRING, required = true, 
			example = "VEVTVA==" )
	@NotNull(message = "Il capo 'data' è obbligatorio")
	@Getter @Setter private String data;
	
	@Schema( description = "La firma detached da verificare", 
			type = SchemaType.STRING, required = true, 
			example = "6c98ebbffe59cdfd0f40692522f7e063a1736ab594e2034b3681e722d98239fd" )
 	@NotNull(message = "La firma detached è obblitatoria")
 	@Getter @Setter private String detached;

}
