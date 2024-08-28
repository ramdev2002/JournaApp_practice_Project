package james.practice.journalApp.service;

import james.practice.journalApp.entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface JournalService {
  void  save(JournalEntity journalEntity,ObjectId id);
  List<JournalEntity> getAll();
  Optional<JournalEntity> getById(ObjectId id);
 void deleteById(ObjectId id);

}
