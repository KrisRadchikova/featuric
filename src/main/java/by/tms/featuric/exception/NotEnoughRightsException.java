package by.tms.featuric.exception;
//для исполнения ролей(недостаточно прав)

public class NotEnoughRightsException extends RuntimeException{
    public NotEnoughRightsException(){
        super();
    }

    public NotEnoughRightsException(String message){
        super(message);
    }
}
