package com.processing.file.json.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class JSONParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> read(Class<T> objectType, final String jsonPath) throws IOException {
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        return objectMapper.readValue(new File(jsonPath), objectMapper.getTypeFactory().constructCollectionType(List.class, objectType));

    }

    public static String readAsTree(final String jsonPath) throws IOException {
        final JsonNode jsonNode = objectMapper.readTree(new File(jsonPath));
        return jsonNode.toPrettyString();

    }

}
