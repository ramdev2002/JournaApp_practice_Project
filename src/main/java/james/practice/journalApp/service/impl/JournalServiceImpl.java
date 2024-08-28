package james.practice.journalApp.service.impl;

import james.practice.journalApp.entity.JournalEntity;
import james.practice.journalApp.repository.JournalRepository;
import james.practice.journalApp.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {
  @Autowired
  private JournalRepository journalRepository;
  @Override
  public void save(JournalEntity journalEntity,ObjectId id) {
    JournalEntity journalEntityFromDb=journalRepository.findById(id).orElse(null);
    if(journalEntityFromDb != null){
      journalEntity.setTitle(journalEntityFromDb.getTitle());
      journalEntity.setContent(journalEntityFromDb.getContent());
      journalEntity.setCreatedDate(Instant.now());
    }
    journalRepository.save(journalEntity);
  }

  @Override
  public List<JournalEntity> getAll() {
    return journalRepository.findAll();
  }

  @Override
  public Optional<JournalEntity> getById(ObjectId id) {
   return journalRepository.findById(id);
  }

  @Override
  public void deleteById(ObjectId id) {
    journalRepository.deleteById(id);
  }
}
