package it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Richiesta del servizio sigillo" )
public class SigilloRequest {

	@Schema( description = "Il pdf in codifica base64", 
			type = SchemaType.STRING, required = true, 
			example = "VEVTVA==" )
	@Getter @Setter private String pdfBase64;

	@Schema( description = "Indica se va applicata la marca temporale",
			type = SchemaType.BOOLEAN, required = false, 
			example = "false", defaultValue = "false" )
	@Getter @Setter private boolean tsa = false;
	
}
