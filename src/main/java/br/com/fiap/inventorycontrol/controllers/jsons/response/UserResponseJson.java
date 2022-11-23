package br.com.fiap.inventorycontrol.controllers.jsons.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseJson {

  private String id;

  private String name;

  private String email;
}
