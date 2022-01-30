package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
    CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedDto.getUuid().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
    customerService.deleteById(customerId);
  }

}
