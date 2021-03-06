package org.springframework.datastore.jcr;

import org.springframework.datastore.core.AbstractDatastore;
import org.springframework.datastore.core.Session;
import org.springframework.datastore.mapping.MappingContext;
import org.springframework.datastore.node.mapping.NodeMappingContext;

import java.util.Map;

/**
 * @author Erawat Chamanont
 * @since 1.0
 */
public class JcrDatastore  extends AbstractDatastore {

    public JcrDatastore(MappingContext mappingContext) {
        super(mappingContext);
    }
    public JcrDatastore(){
        super(new NodeMappingContext());
    }

    @Override
    protected Session createSession(Map<String, String> connectionDetails) {
        System.setProperty("org.apache.jackrabbit.repository.conf", connectionDetails.get("configuration"));
        System.setProperty("org.apache.jackrabbit.repository.home", connectionDetails.get("homeDir"));
        return new JcrSession(connectionDetails, getMappingContext());  
    }

}
