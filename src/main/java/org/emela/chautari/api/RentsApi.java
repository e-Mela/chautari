/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.emela.chautari.api;

import org.emela.chautari.model.*;
import org.springframework.core.io.Resource;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

@Validated
@Api(value = "rents", description = "the rents API")
public interface RentsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "create new rental item", nickname = "createRental", notes = "Provides user to post new rental item", response = RentalItemResponse.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RentalItemResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<RentalItemResponse> createRental(@ApiParam(value = ""  )  @Valid @RequestBody RentalItemRequest rentalItemRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"rental-id\" : \"rental-id\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "delete rental item", nickname = "deleteRental", notes = "Provides user to delete posted rental item", response = RentalItemResponse.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RentalItemResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/{rental-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<RentalItemResponse> deleteRental(@ApiParam(value = "",required=true) @PathVariable("rental-id") String rentalId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"rental-id\" : \"rental-id\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "return resource", nickname = "deleteResource", notes = "Provide endpoint to upload resources", response = ResourceResponse.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ResourceResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/resource/{resource-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<ResourceResponse> deleteResource(@ApiParam(value = "",required=true) @PathVariable("resource-id") String resourceId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"message\",  \"resource-id\" : \"resource-id\",  \"status\" : \"status\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "return rental detail information", nickname = "getRentalItems", notes = "Provides rental item detail information", response = RentalItemDetail.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RentalItemDetail.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/{rental-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<RentalItemDetail> getRentalItems(@ApiParam(value = "",required=true) @PathVariable("rental-id") String rentalId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"preferences\" : [ {    \"preference\" : \"preference\",    \"priority\" : \"high\"  }, {    \"preference\" : \"preference\",    \"priority\" : \"high\"  } ],  \"availability\" : {    \"not-available\" : [ {      \"end-date\" : \"end-date\",      \"start-date\" : \"start-date\"    }, {      \"end-date\" : \"end-date\",      \"start-date\" : \"start-date\"    } ],    \"available\" : {      \"end-date\" : \"end-date\",      \"start-date\" : \"start-date\"    }  },  \"title\" : \"title\",  \"postedBy\" : {    \"address\" : {      \"zip\" : 0,      \"country\" : \"country\",      \"address2\" : \"address2\",      \"city\" : \"city\",      \"address1\" : \"address1\",      \"state\" : \"state\"    },    \"person\" : {      \"firstName\" : \"firstName\",      \"lastName\" : \"lastName\",      \"middleName\" : \"middleName\",      \"title\" : \"Mr\"    }  },  \"image-ids\" : [ \"123423241\", \"123423241\" ],  \"features\" : {    \"not-available\" : [ \"not-available\", \"not-available\" ],    \"available\" : [ \"available\", \"available\" ]  },  \"viewedBy\" : 0,  \"price\" : {    \"type\" : true,    \"value\" : 0.80082819046101150206595775671303272247314453125  },  \"contact\" : {    \"phoneNumber\" : \"phoneNumber\",    \"email\" : \"email\"  },  \"postedOn\" : \"postedOn\",  \"location\" : {    \"zip\" : 0,    \"country\" : \"country\",    \"address2\" : \"address2\",    \"city\" : \"city\",    \"address1\" : \"address1\",    \"state\" : \"state\"  },  \"rentOf\" : \"room\",  \"status\" : \"New\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "return list of available rental items", nickname = "getRentals", notes = "Provides available rental items summary filtering by title, location, type, availability, feature and preference", response = RentalItemSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RentalItemSummary.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<RentalItemSummary>> getRentals(@ApiParam(value = "") @Valid @RequestParam(value = "title", required = false) String title,@ApiParam(value = "") @Valid @RequestParam(value = "location", required = false) String location,@ApiParam(value = "") @Valid @RequestParam(value = "type", required = false) String type,@ApiParam(value = "start date and end date") @Valid @RequestParam(value = "availability", required = false) String availability,@ApiParam(value = "") @Valid @RequestParam(value = "feature", required = false) String feature,@ApiParam(value = "") @Valid @RequestParam(value = "preference", required = false) String preference) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"price\" : {    \"type\" : true,    \"value\" : 0.80082819046101150206595775671303272247314453125  },  \"location\" : {    \"zip\" : 0,    \"country\" : \"country\",    \"address2\" : \"address2\",    \"city\" : \"city\",    \"address1\" : \"address1\",    \"state\" : \"state\"  },  \"rentOf\" : \"rentOf\",  \"title\" : \"title\",  \"image-id\" : \"image-id\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "return resource", nickname = "getResource", notes = "Provide endpoint to upload resources", response = Resource.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Resource.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/resource/{resource-id}",
        produces = { "image/_*", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Resource> getResource(@ApiParam(value = "",required=true) @PathVariable("resource-id") String resourceId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "upload resources", nickname = "resourceUpload", notes = "Provide endpoint to upload resources", response = ResourceResponse.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ResourceResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/resource",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    default ResponseEntity<List<ResourceResponse>> resourceUpload(@ApiParam(value = "" ) @RequestHeader(value="user-id", required=false) String userId,@ApiParam(value = "" ) @RequestHeader(value="rental-id", required=false) String rentalId,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"message\",  \"resource-id\" : \"resource-id\",  \"status\" : \"status\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "update rental item", nickname = "uptateRental", notes = "Provides user to update rental item", response = RentalItemResponse.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RentalItemResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorModel.class),
        @ApiResponse(code = 401, message = "Unauthorized, Invalid or Missing Access Token", response = ErrorModel.class),
        @ApiResponse(code = 403, message = "Access Denied, Insufficient Scope privilege Or Expired Access Token", response = ErrorModel.class),
        @ApiResponse(code = 404, message = "Resource Not Found", response = ErrorModel.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorModel.class),
        @ApiResponse(code = 200, message = "Server Errors", response = ErrorModel.class) })
    @RequestMapping(value = "/rents/{rental-id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<RentalItemResponse> uptateRental(@ApiParam(value = "",required=true) @PathVariable("rental-id") String rentalId,@ApiParam(value = ""  )  @Valid @RequestBody RentalItemRequest rentalItemRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"rental-id\" : \"rental-id\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
