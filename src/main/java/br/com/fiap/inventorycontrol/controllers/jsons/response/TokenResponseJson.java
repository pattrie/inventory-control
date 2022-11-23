package br.com.fiap.inventorycontrol.controllers.jsons.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class TokenResponseJson {

  private String token;
  private String type;
}
