package platform.code;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CodeEntity(String code, @JsonProperty("date") String creationDate) {
}

