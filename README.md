# url-shortener
A Java Spring Boot application service that shortens long urls using redis as the live in-memory storage.

## Parameters

- **page** — Return a specific page in the photo stream. Page numbering is 1-based.
- **rpp** — The number of results to return. Can not be over 100, default 20.

***

## Return format
A JSON object containing users that liked that photo.

- **current_page** — Number of the page that is returned.
- **total_pages** — Total number of pages in this feature's stream.
- **total_items** — Total number of items in this feature's stream.
- **users** — Profile of the author of the comment in **[short format][]**.

***

## Errors
All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.

- **403 Forbidden** — The photo was either deleted, belongs to a deactivated user.
- **404 Not Found** — Photo with the specified ID does not exist.


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

