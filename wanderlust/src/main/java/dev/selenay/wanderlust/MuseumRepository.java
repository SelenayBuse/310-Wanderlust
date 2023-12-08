package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MuseumRepository extends MongoRepository<Museums, ObjectId> {
}
