package com.ms.accelerator;

import static org.junit.Assert.assertEquals;

import com.ms.accelerator.model.Quote;
import com.ms.accelerator.resource.in.Claim;
import com.ms.accelerator.resource.in.Part;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
    Application.class})
public class QuoteResourceComponentTest {

  @LocalServerPort
  private int port;


  private TestRestTemplate testRestTemplate = new TestRestTemplate();

  @Test
  public void testQuoteEstimate200(){

    Claim claimRequest = Claim.builder().damagedParts(new Part[]{Part.builder().modelPart("bumper")
        .severity("100")
        .build()})
        .dateReported("2020-01-12").model("alto").userId("1").build();

    ResponseEntity<Quote> response = testRestTemplate.postForEntity(getQuoteUrl(),
        claimRequest, Quote.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());



  }

  private String getQuoteUrl(){
    return "http://localhost:" + port + "/quote/estimate";

  }
}
