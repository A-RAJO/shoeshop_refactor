package com.github.chore.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// 예시 : ResponseDTO.success(user) 호출 → 내부적으로 new ResponseDTO<>(true, 200, "요청 성공", user)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T>  {
    private int status;       // HTTP 상태 코드 또는 커스텀 코드
    private String message;   // 성공, 실패 메세지
    private T data;           // 실제 응답 데이터
    // 성공 응답
    public static <T> ResponseDTO<T> success(String message) {
        return new ResponseDTO<>(200,message,null);
    }
    public static <T> ResponseDTO<T> success(String message,T data) {
        return new ResponseDTO<>(200,message,data);
    }

    // 실패 응답

    public static <T> ResponseDTO<T> fail(int status, String message) {
        return new ResponseDTO<>(status, message, null);
    }

    public static <T> ResponseDTO<T> fail(int status, String message, T data) { // 실패응답이 담긴 객체까지 전달
        return new ResponseDTO<>(status, message, data);
    }

    public static <T> ResponseDTO<Exception> fail(int status, String message, Exception e) { //예외 처리 메세지까지 전달
        return new ResponseDTO<>(status, message,e);
    }




}
