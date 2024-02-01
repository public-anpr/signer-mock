package it.sogei.ansc.signer.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
	    tags = {
	            @Tag(name="firma", description="Operazioni per la firma remota detached"),
	            @Tag(name="sigillo", description="Operazioni per il sigillo"),
	            @Tag(name="composizione", description="Operazioni composizione p7m"),
	            @Tag(name="verifica", description="Operationi verifica firma detached"),
	    },
	    info = @Info(
	        title="API di firma per il progetto ANSC",
	        version = "1.0.0",
	        contact = @Contact(
	            name = "Matteo Franci",
	            url = "https://github.com/italia/ansc",
	            email = "mttfranci@sogei.it") )
	)
public class OpenApiSigner extends Application {

}
