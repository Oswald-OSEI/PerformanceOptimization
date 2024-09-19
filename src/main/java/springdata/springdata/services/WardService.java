package springdata.springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.springdata.dtos.WardDto;
import springdata.springdata.entities.Ward;
import springdata.springdata.repositories.WardRepository;

@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;

    public WardDto addWard(WardDto wardDto) {
      Ward ward = wardRepository.save(convertToEntity(wardDto));
      wardDto.setId(ward.getId());
      return wardDto;
    }

    private WardDto convertToDto(Ward ward) {
        WardDto wardDto = new WardDto();
        wardDto.setId(ward.getId());
        wardDto.setDepartment(ward.getDepartment());
        wardDto.setWardNumber(ward.getWardNumber());
        wardDto.setSupervisor(ward.getSupervisor());
        wardDto.setBedList(ward.getBedList());
        return wardDto;
    }

    private Ward convertToEntity(WardDto wardDto) {
        Ward ward = new Ward();
        ward.setId(wardDto.getId());
        ward.setDepartment(wardDto.getDepartment());
        ward.setWardNumber(wardDto.getWardNumber());
        ward.setSupervisor(wardDto.getSupervisor());
        ward.setBedList(wardDto.getBedList());
        return ward;
    }
}
