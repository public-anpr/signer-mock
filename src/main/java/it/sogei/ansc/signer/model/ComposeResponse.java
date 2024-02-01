package  it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Risposta del servizio di composizione p7m" )
public class ComposeResponse {

	@Schema( description = "Il risultato della composizione, 0 = OK, -1 = errore", 
			type = SchemaType.INTEGER,
			example = "0" )
	@Getter @Setter  private Integer result;

	@Schema( description = "Il p7m codificato base54", 
			type = SchemaType.STRING,
			example = "VEVTVA==" )
	@Getter @Setter  private String pkcs7;

}
