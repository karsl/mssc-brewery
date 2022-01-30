package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID customerUuid) {
    return CustomerDto.builder().uuid(customerUuid).name("Name Surname2").build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    return CustomerDto.builder()
        .uuid(UUID.randomUUID())
        .build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    // TODO impl - would add a reak impl to update beer
  }

  @Override
  public void deleteById(UUID customerId) {
    log.debug("Deleting a customer...");
  }

}
