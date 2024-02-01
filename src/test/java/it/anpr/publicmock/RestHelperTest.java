package it.anpr.publicmock;

import org.fugerit.java.core.cfg.ConfigException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.sogei.ansc.signer.config.SignerConsts;
import it.sogei.ansc.signer.rest.RestHelper;
import jakarta.ws.rs.core.Response;

class RestHelperTest {
	
    @Test
    void test500() {
    	Assertions.assertEquals( Response.Status.INTERNAL_SERVER_ERROR.getStatusCode() , 
    			RestHelper.handle( () -> { throw new ConfigException( "test" ); } , SignerConsts.SIGNER_FAIL ).getStatus() );
    }

    
}