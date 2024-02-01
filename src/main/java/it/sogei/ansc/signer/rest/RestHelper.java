package it.sogei.ansc.signer.rest;

import org.fugerit.java.core.function.UnsafeSupplier;

import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestHelper {
	
	private RestHelper() {}

	public static Response handle( UnsafeSupplier<Response, Exception> fun, int errorCode ) {
		Response res = null;
		try {
			res = fun.get();
		} catch (Exception e) {
			log.error( "ERRORE : "+e, e );
			ErrorStatus status = new ErrorStatus();
			status.setResult(errorCode);
			res = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity( status ).build();
		}
		return res;
	}
	
}
