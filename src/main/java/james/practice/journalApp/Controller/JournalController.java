package james.practice.journalApp.Controller;

import james.practice.journalApp.entity.JournalEntity;
import james.practice.journalApp.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {
  private final JournalService journalService;

  @PostMapping("/{id}")
  public void saveJournal(@RequestBody JournalEntity journalEntity,@PathVariable ObjectId id){
    journalService.save(journalEntity,id);
  }
  @GetMapping
  public List<JournalEntity> getAllJournal(){
   return journalService.getAll();
  }
  @GetMapping("/{id}")
  public Optional<JournalEntity> getJournalById(@PathVariable ObjectId id){
    return journalService.getById(id);
  }
  @DeleteMapping("/{id}")
  public void deleteJournalById(@PathVariable ObjectId id){
    journalService.deleteById(id);
  }
}
