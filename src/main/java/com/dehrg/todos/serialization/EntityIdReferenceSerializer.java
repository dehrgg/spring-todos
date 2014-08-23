package com.dehrg.todos.serialization;

import java.io.IOException;

import com.dehrg.todos.model.PersistentEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EntityIdReferenceSerializer extends JsonSerializer<PersistentEntity<Long>> {

	@Override
	public void serialize(PersistentEntity<Long> value, JsonGenerator jgen, SerializerProvider provider) 
			throws IOException, JsonProcessingException {
		jgen.writeNumber(value.getId());
	}

}
