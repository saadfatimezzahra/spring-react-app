package ma.oncf.rexbackend.Exceptions;

public class UserException extends Exception{

    public String userNotFound(){
        return "user not found" ;
    }
}
