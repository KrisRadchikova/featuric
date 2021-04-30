package by.tms.featuric.exception;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class ExistsException extends RuntimeException{

    public ExistsException(){
        super();
    }

    public ExistsException(String message){
        super(message);
    }
}
