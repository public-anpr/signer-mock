package it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Risposta del servizio sigillo" )
public class SigilloResponse {

	@Schema( description = "Il risultato della composizione, 0 = OK, -1 = errore", 
			type = SchemaType.INTEGER,
			example = "0" )
  	@Getter @Setter private Integer result;

	@Schema( description = "Il pdf firmato codificato base64", 
			type = SchemaType.STRING,
			example = "VEVTVA==" )
  	@Getter @Setter private String pdfSigned;

	@Schema( description = "L'hash della firma", 
			type = SchemaType.STRING,
			example = "6c98ebbffe59cdfd0f40692522f7e063a1736ab594e2034b3681e722d98239fd" )
  	@Getter @Setter private String hash;
	
}
