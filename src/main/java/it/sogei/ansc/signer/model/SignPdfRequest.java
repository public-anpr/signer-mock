package it.sogei.ansc.signer.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Schema( description = "Richiesta del servizio di firma pdf" )
public class SignPdfRequest {

	@Schema( description = "Il pdf codificato base64", 
			type = SchemaType.STRING, required = true, 
			example = "VEVTVA==" )
	@Getter @Setter private String pdfBase64;

	@Schema( description = "Lo username del servizio di firma remoto", 
			type = SchemaType.STRING, required = true, 
			example = "user1" )
	@Getter @Setter private String username;

	@Schema( description = "L'OTP del servizio di firma remoto", 
			type = SchemaType.STRING, required = true, 
			example = "13232" )
	@Getter @Setter  private String otpPwd;

	@Schema( description = "La password del servizio di firma remoto", 
			type = SchemaType.STRING, required = true, 
			example = "pass1" )
	@Getter @Setter  private String userPwd;
	
}
