# url-shortener
A Java Spring Boot application service that shortens long urls using redis as the live in-memory storage.

## Parameters

- **link** — Takes a long url in text format as body param

***

## Errors
All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.


***

## Demo
**Request**
Link below as text

    https://www.google.com/search?ei=uWgSXLfLIIackwWTuKaICQ&q=java+servlet+redirection+for+spring+app+tutotrial+video&oq=java+servlet+redirection+for+spring+app+tutotrial+video&gs_l=psy-ab.3...479458.485831..486910...1.0..1.354.3210.0j12j2j2......0....1..gws-wiz.......0i71.rXrFLy_gmFw

**Return** 
``` json
{
    "code": "00",
    "description": "Successful",
    "errors": null,
    "shortUrl": "http://localhost:8080/rest/22adc505"
}

**Redirect to Initial url** 

