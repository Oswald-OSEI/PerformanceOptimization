package springdata.springdata.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import springdata.springdata.config.GcStatsUtil;
import springdata.springdata.dtos.BedDto;
import springdata.springdata.entities.Bed;
import springdata.springdata.repositories.BedRepository;

@Service
public class BedService {
    private final TransactionTemplate transactionTemplate;
    BedRepository bedRepository;

    public BedService(BedRepository bedRepository, TransactionTemplate transactionTemplate) {
        this.bedRepository = bedRepository;
        this.transactionTemplate = transactionTemplate;

    }


    public synchronized BedDto addBed(BedDto bedDto) throws Exception {
        Bed newBed = bedRepository.save(convertToEntity(bedDto));
        System.out.println(GcStatsUtil.getGcStats());
        return convertToDto(newBed);
    }


    public synchronized List<BedDto> getAllBeds() throws Exception {
        List<Bed> beds = bedRepository.findAll();
        List<BedDto> bedDtos = new ArrayList<>();
        for (Bed bed : beds) {
            bedDtos.add(convertToDto(bed));
        }
        System.out.println(GcStatsUtil.getGcStats());
        return bedDtos;
    }


    public BedDto getBedById(Long id) throws Exception {
        List<BedDto> allBeds = getAllBeds();
        for (BedDto bedDto : allBeds) {
            if (bedDto.getId().equals(id)) {
                return bedDto;
            }
        }
        throw new RuntimeException("Bed not found");
    }


    public synchronized BedDto updateBed(BedDto bedDto) throws Exception {
        BedDto editedBedDto = new BedDto();
        if (bedDto.getId() != null) {
            Optional<Bed> editBed = bedRepository.findById(bedDto.getId());
            if (editBed.isPresent()) {
                Bed bed = editBed.get();
                bed.setBedNumber(bedDto.getBedNumber());
                bed.setWard(bedDto.getWard());
                bedRepository.save(bed);
                editedBedDto.setBedNumber(bedDto.getBedNumber());
                editedBedDto.setWard(bedDto.getWard());
            }
        }
        System.out.println(GcStatsUtil.getGcStats());
        return editedBedDto;
    }


    public synchronized void deleteBed(long id) {
        bedRepository.deleteById(id);
    }

    public BedDto convertToDto(Bed bed) {
        BedDto bedDto = new BedDto();
        bedDto.setId(bed.getId());
        bedDto.setBedNumber(bed.getBedNumber());
        bedDto.setWard(bed.getWard());
        return bedDto;
    }

    public Bed convertToEntity(BedDto bedDto) {
        Bed bed = new Bed();
        bed.setBedNumber(bedDto.getBedNumber());
        bed.setWard(bedDto.getWard());
        return bed;
    }
}