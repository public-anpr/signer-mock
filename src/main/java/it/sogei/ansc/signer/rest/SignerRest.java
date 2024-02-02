package it.sogei.ansc.signer.rest;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import it.sogei.ansc.signer.config.SignerConsts;
import it.sogei.ansc.signer.model.SigilloRequest;
import it.sogei.ansc.signer.model.SigilloResponse;
import it.sogei.ansc.signer.model.SignPdfRequest;
import it.sogei.ansc.signer.model.SignPdfResponse;
import it.sogei.ansc.signer.model.SignRequest;
import it.sogei.ansc.signer.model.SignResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "/ansc/signer")
public class SignerRest {

	@Operation(operationId = "firma remota", summary = "permette la firma remota detached")
	@POST
	@Path(value = "/sign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Tag(name = "firma")
	public Response sign(
			@RequestBody(description = "Parametri firma", required = true, content = @Content(schema = @Schema(implementation = SignRequest.class))) @Valid SignRequest signerIn) {
		return RestHelper.handle( () -> {
			SignResponse signerOut = new SignResponse();
			signerOut.setResult( SignerConsts.OK );
			signerOut.setDetached( UUID.randomUUID().toString() );
			return Response.ok( signerOut ).build();
		} , SignerConsts.SIGNER_FAIL );
	}
	
	@Operation(operationId = "firma remota pdf", summary = "permette la firma remota pdf")
	@POST
	@Path(value = "/signpdf")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Tag(name = "firma")
	public Response signpdf(
			@RequestBody(description = "Parametri firma", required = true, content = @Content(schema = @Schema(implementation = SignPdfRequest.class))) @Valid SignPdfRequest signerIn) {
		return RestHelper.handle( () -> {
			SignPdfResponse signerOut = new SignPdfResponse();
			signerOut.setResult( SignerConsts.OK );
			signerOut.setPdfSigned( signerIn.getPdfBase64() );
			return Response.ok( signerOut ).build();
		} , SignerConsts.SIGNER_FAIL );
	}
	
	@Operation(operationId = "sigillo remoto", summary = "permette di applicare il sigillo ad un pdf")
	@POST
	@Path(value = "/sigillopdf")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Tag(name = "sigillo")
	public Response sigillopdf(
			@RequestBody(description = "Parametri sigillo", required = true, content = @Content(schema = @Schema(implementation = SigilloRequest.class))) @Valid SigilloRequest signerPdfIn) {
		return RestHelper.handle( () -> {
			SigilloResponse signerPdfOut = new SigilloResponse();
			signerPdfOut.setResult( SignerConsts.OK );
			signerPdfOut.setPdfSigned( signerPdfIn.getPdfBase64() );
			return Response.ok( signerPdfOut ).build();  
		} , SignerConsts.SIGNER_FAIL );
	}

}
