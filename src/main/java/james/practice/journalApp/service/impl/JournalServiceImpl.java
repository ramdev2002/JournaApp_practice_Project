package james.practice.journalApp.service.impl;

import james.practice.journalApp.entity.JournalEntity;
import james.practice.journalApp.repository.JournalRepository;
import james.practice.journalApp.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

  private final JournalRepository journalRepository;

  @Override
  public JournalEntity save(JournalEntity journalEntity, ObjectId id) {
    JournalEntity journalEntityFromDb = journalRepository.findById(id).orElse(null);
    if (journalEntityFromDb != null) {
      journalEntityFromDb.setTitle(journalEntity.getTitle() != null && !journalEntity.getTitle().isEmpty()
              ? journalEntity.getTitle()
              : journalEntityFromDb.getTitle());

      journalEntityFromDb.setContent(journalEntity.getContent() != null && !journalEntity.getContent().isEmpty()
              ? journalEntity.getContent()
              : journalEntityFromDb.getContent());

      journalEntityFromDb.setCreatedDate(Instant.now());
      return journalRepository.save(journalEntityFromDb);
    }
    return journalRepository.save(journalEntity);
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
