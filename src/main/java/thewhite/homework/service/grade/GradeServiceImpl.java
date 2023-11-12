package thewhite.homework.service.grade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thewhite.homework.exception.NotFoundException;
import thewhite.homework.model.Grade;
import thewhite.homework.repository.grade.GradeRepository;
import thewhite.homework.service.grade.argument.CreateGradeArgument;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public Grade create(CreateGradeArgument argument) {
        UUID id = UUID.randomUUID();
        return gradeRepository.save(Grade.builder()
                                         .id(id)
                                         .entryId(argument.getEntryId())
                                         .rating(argument.getRating())
                                         .comment(argument.getComment())
                                         .build());
    }

    @Override
    public void delete(UUID id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public List<Grade> getAllExisting(Long entryId) {
        return Optional.ofNullable(gradeRepository.findAllById(entryId))
                       .orElseThrow(() -> new NotFoundException("Оценка не найдена"));
    }
}
