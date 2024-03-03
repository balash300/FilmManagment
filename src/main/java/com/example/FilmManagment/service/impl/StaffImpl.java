package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.StaffDto;
import com.example.FilmManagment.dto.request.StaffRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.StaffMapper;
import com.example.FilmManagment.model.Staff;
import com.example.FilmManagment.repository.StaffRepository;
import com.example.FilmManagment.service.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffImpl implements StaffService {

    private final StaffRepository repository;
    private final StaffMapper mapper;

    @Override
    public StaffDto getStaffByStaffId(Long staffId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(staffId)
                .orElseThrow(()-> new ResourceNotFoundException("Staff","staffId",staffId)));
    }

    @Override
    public Staff saveStaff(StaffRequest request) {
        Staff staff = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return staff;
    }

    @Override
    public StaffDto updateStaff(StaffRequest request) {
        log.info("Finding information for id: {}", request.getStaffId());
        if (repository.findById(request.getStaffId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getStaffId());
        } else {
            log.info("Updating information for id: {}", request.getStaffId());
            Staff updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getStaffId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Staff", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<StaffDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
