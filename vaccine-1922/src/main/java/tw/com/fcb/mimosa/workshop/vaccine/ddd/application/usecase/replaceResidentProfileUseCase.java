package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.usecase;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.ext.ddd.application.ApplicationUseCase;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ReplaceResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;

@Service
@RequiredArgsConstructor
public class replaceResidentProfileUseCase implements ApplicationUseCase<ReplaceResidentProfile, Void> {

  final AppointmentRepository repository;

  @Override
  public Void execute(@NotNull @Valid ReplaceResidentProfile command) {
    var domain = repository.findById(command.getId());
    if (StringUtils.hasText(command.getPhoneNo())) {
      domain.setPhoneNo(command.getPhoneNo());
      repository.save(domain);
    }
    return null;
  }

}
