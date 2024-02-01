package it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Risposta del servizio di verifica di una firma detached" )
public class VerifierResponse {
	
	@Schema( description = "Il risultato della composizione, 0 = Valido, -1 = Non valida, -2 = errore durante la verifica", 
			type = SchemaType.INTEGER,
			example = "0" )
	@Getter @Setter private Integer result;

}
