package pe.kr.kit.test.exception;


import pe.kr.kit.test.enums.LoginStatus;

//로그인만 관리하는 예외처리 클래스
public class LoginException extends Exception{
    public LoginException(LoginStatus status) {
//        String message = "";
//        switch (status) {
//            case LoginStatus.ID_ERROR:
//                message = "로그인에러";
//                break;
//        }
        super(status.toString());
    }
}
