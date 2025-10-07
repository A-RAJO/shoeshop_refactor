package com.github.chore.web.dto;


import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResTokenDTO {


  private String user_token;
  private String user_refreshtoken;
  private String role;
  //private List<String> role;

}
