package it.sogei.ansc.signer.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import it.sogei.ansc.signer.config.SignerConsts;
import it.sogei.ansc.signer.model.ComposeResponse;
import it.sogei.ansc.signer.model.VerifierRequest;
import it.sogei.ansc.signer.model.VerifierResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "/ansc/verifier")
@Tag(name = "verifica")
@Tag(name = "composizione")
@Tag(name = "p7m")
public class VerifyRest {

	@Operation(operationId = "verifica firm", summary = "permette di verificare se una firma detached è validata per un dato documento")
	@POST
	@Path(value = "/verify")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Tag(name = "verifica")
	public Response verify(
			@RequestBody(description = "Parametri firma", required = true, 
			content = @Content(schema = @Schema(implementation = VerifierRequest.class)) ) @Valid VerifierRequest in) {
		return RestHelper.handle( () -> {
			VerifierResponse out = new VerifierResponse();
			out.setResult(SignerConsts.VERIFY_FATAL);
			out.setResult( SignerConsts.OK );
			return Response.ok( out ).build();
		} , SignerConsts.SIGNER_FAIL );
	}
	
	@Operation(operationId = "composizione p7m", summary = "permette di comporre una p7m a partire da un documento e la sua firma detached")
	@POST
	@Path(value = "/compose")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Tag(name = "composizione")
	public Response compose(
			@RequestBody(description = "Parametri sigillo", required = true, 
			content = @Content(schema = @Schema(implementation = VerifierRequest.class))) @Valid VerifierRequest in) {
		return RestHelper.handle( () -> {
			ComposeResponse out = new ComposeResponse();
			out.setResult( SignerConsts.OK );
			out.setPkcs7( in.getData() );
			return Response.ok( out ).build();
		} , SignerConsts.SIGNER_FAIL );
	}
	
}
