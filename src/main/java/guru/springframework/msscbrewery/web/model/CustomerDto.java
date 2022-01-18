package guru.springframework.msscbrewery.web.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

  private UUID uuid;
  private String name;

}
