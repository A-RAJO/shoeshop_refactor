package com.github.chore.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private boolean success;  // 요청 성공 여부
    private int status;       // HTTP 상태 코드 또는 커스텀 코드
    private String message;   // 성공/실패 메시지
    private T data;           // 실제 응답 데이터

    // 성공 응답
    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(true, 200, "성공", data);
    }
    // 예시 : ResponseDTO.success(user) 호출 → 내부적으로 new ResponseDTO<>(true, 200, "요청 성공", user)

    public static <T> ResponseDTO<T> success(T data, String message) {
        return new ResponseDTO<>(true, 200, message, data);
    }

    // 실패 응답
    public static <T> ResponseDTO<T> fail(int status, String message, T data) { // 실패응답이 담긴 객체까지 전달
        return new ResponseDTO<>(false, status, message, data);
    }
    public static <T> ResponseDTO<T> fail(int status, String message) {
        return new ResponseDTO<>(false, status, message, null);
    }
    public static <T> ResponseDTO<T> fail(String message) {
        return new ResponseDTO<>(false, 400, message, null);
    }
}
